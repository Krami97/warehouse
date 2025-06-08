package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@AllArgsConstructor
@Data
public class UserCreateDto {

    static final List<String> allRoles = List.of("ROLE_USER","ROLE_ADMIN");
    @Size(min = 4,max=32)
    String username;
    @Size(min = 8,max=32)
    String password;
    @NotEmpty
    @Email(message = "Invalid email format")
    String email;
    @NotEmpty
    String role;


    public void setRole(String role)  {
        if(allRoles.contains(role)){
            this.role = role;
        }else{
            throw new IllegalArgumentException("That role dose not exist!");
        }

    }
}

