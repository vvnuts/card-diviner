package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naimix.model.RolesResponse;
import ru.naimix.service.RoleService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    @GetMapping
    private ResponseEntity<RolesResponse> getRolesResponse(){
        var rolesResponse = roleService.getRolesResponse();
        return new ResponseEntity<>(rolesResponse, OK);
    }
}
