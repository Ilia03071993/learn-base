package com.selivanov.controller;

import com.selivanov.dto.UserDto;
import com.selivanov.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody UserDto userDto) {
        roleService.saveRole(userDto.role());

        return ResponseEntity.ok().build();
    }
}
