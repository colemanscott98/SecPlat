package com.coleman.security.services;

import com.coleman.security.repositories.RoleRepository;

public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
