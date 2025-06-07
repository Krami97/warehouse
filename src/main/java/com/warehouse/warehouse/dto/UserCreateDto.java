package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Data
public class UserCreateDto {

    List<String> allRoles = List.of("ROLL_USER","ROLL_ADMIN");
    @Size(min = 4,max=32)
    String username;
    @Size(min = 8,max=32)
    String password;
    @NotEmpty
    @Email(message = "Invalid email format")
    String email;
    @NotEmpty
    String role;


    public void setRole(String role){
        for (String Role : allRoles) {
            if(Role)
        }
    }
}
