package com.example.authenticationjwt.config;

import com.example.authenticationjwt.config.jwt.CustomAuthenticationFilter;
import com.example.authenticationjwt.config.jwt.JwtUtil;
import com.example.authenticationjwt.config.jwt.JwtValidationFilter;
import com.example.authenticationjwt.config.jwt.RefreshTokenFilter;
import com.example.authenticationjwt.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableMethodSecurity()
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    //login
    // log pas
    //UDS
    //security context (user)

    //request -> SecurityFilterChain -> response (200, 401, 403)
    //1. AuthenticationFilter
    //2. AuthorizationFilter
    //3. CsrfFilter
    //4. AuthorizationFilter: @PreAuthorize & @PostAuthorize
    //5. JwtValidationFilter
    // ...
    //6. Controller

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authManager) throws Exception {
        httpSecurity
//              .securityContext(ctx -> ctx.requireExplicitSave(false))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/api/admin/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET).hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
//                .httpBasic(Customizer.withDefaults());
                .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .addFilter(new CustomAuthenticationFilter(authManager, jwtUtil))
                .addFilterAfter(new JwtValidationFilter(jwtUtil), CustomAuthenticationFilter.class)
                .addFilterAfter(new RefreshTokenFilter(jwtUtil), JwtValidationFilter.class)
                .httpBasic(b -> b.disable())
                .formLogin(l -> l.disable());
//                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(ApplicationUserRepository userRepository) {
        return new CustomUserDetailsService(userRepository);
    }

    @Bean
    public DaoAuthenticationProvider dbDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}