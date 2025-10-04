package com.warehouse.warehouse.auth;

import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role findByName(String name);
}
