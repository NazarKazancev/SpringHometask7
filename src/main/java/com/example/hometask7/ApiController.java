package com.example.hometask7;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class ApiController {

    @GetMapping("public/api")
    public String publicApi() {
        return "public api";
    }

    @RolesAllowed("ADMIN")
    @GetMapping("admin/api")
    public String adminApi(Authentication authentication) {
        return "Name: " + authentication.getName() + " role: ADMIN";
    }

    @RolesAllowed("SUPPORT")
    @GetMapping("support/api")
    public String supportApi(Authentication authentication) {
        return "Name: " + authentication.getName() + " role: SUPPORT";
    }
}
