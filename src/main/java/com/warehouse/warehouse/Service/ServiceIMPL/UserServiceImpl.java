package com.warehouse.warehouse.Service.ServiceIMPL;

import com.warehouse.warehouse.Service.RoleService;
import com.warehouse.warehouse.Service.UserService;
import com.warehouse.warehouse.dto.UserCreateDto;
import com.warehouse.warehouse.entity.Role;
import com.warehouse.warehouse.entity.Users;
import com.warehouse.warehouse.repository.RoleRepo;
import com.warehouse.warehouse.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleService roleService;

    @Override
    public List<Users> get() {
        return userRepo.findAll();
    }

    @Override
    public Users findById(Integer id) {
        Optional<Users>  user  = userRepo.findById(id);
        if(user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public Users create(UserCreateDto dto) {
        Users newUser = new Users();
        Role role = roleService.findByName(dto.getRole());
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(dto.getPassword());
        newUser.setRole(role);
        newUser.setUsername(dto.getUsername());
        return userRepo.save(newUser);
    }

    @Override
    public Users patch(Map<String, Object> updates,Integer id) {
        Users user = findById(id);

        for(Map.Entry<String,Object> entry : updates.entrySet()){
            try {
                Field field = Users.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(user,entry.getValue());
            }catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return userRepo.save(user);
    }

    @Override
    public void delete(Integer id) {
        Users user = findById(id);
        userRepo.delete(user);
    }

    @Override
    public Users findByName(String name) {
        Optional<Users> user = userRepo.findByUsername(name);
        if(user.isEmpty()){
            throw new EntityNotFoundException("No found user with that name");
        }
        return user.get();
    }
}
