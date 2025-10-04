package com.warehouse.warehouse.auth;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    @Override
    public Role findByName(String name) {
        Optional<Role> role = roleRepo.findByName(name);
        if(role.isEmpty()){
            throw new EntityNotFoundException("No such role");
        }
        return role.get() ;
    }
}
