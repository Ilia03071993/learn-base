package com.selivanov.mapper;

import com.selivanov.dto.UserDto;
import com.selivanov.entity.ApplicationUser;
import com.selivanov.entity.Role;
import com.selivanov.service.RoleService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(target = "password", expression = "java(encodePassword(userDto.password(), passwordEncoder))")
//    @Mapping(target = "roles", expression = "java(getRoleSet(userDto.role(), roleService))")
//    ApplicationUser toEntity(UserDto userDto, @Context RoleService roleService, @Context PasswordEncoder passwordEncoder);

    @Named("getRoleSet")
    default Set<Role> getRoleSet(UserDto userDto, @Context RoleService roleService) {
        return Set.of(roleService.findRoleByName(userDto));
    }

    @Named("encodePassword")
    default String encodePassword(String password, @Context PasswordEncoder passwordEncoder) {
        return passwordEncoder.encode(password);
    }
}