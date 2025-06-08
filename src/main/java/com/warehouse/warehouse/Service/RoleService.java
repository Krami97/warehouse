package com.warehouse.warehouse.Service;

import com.warehouse.warehouse.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role findByName(String name);
}
