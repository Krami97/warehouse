package com.warehouse.warehouse.components;

import com.warehouse.warehouse.entity.Role;
import com.warehouse.warehouse.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExist("ROLE_USER");
        createRoleIfNotExist("ROLE_ADMIN");

    }

    private void createRoleIfNotExist(String roleName){
        if(roleRepo.findByName(roleName).isEmpty()){
            Role role = new Role();
            role.setName(roleName);
            roleRepo.save(role);
        }
    }


}
