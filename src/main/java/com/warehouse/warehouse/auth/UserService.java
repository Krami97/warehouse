package com.warehouse.warehouse.auth;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Users> get();

    Users findById(Integer id);
    Users create(UserCreateDto dto);
    Users patch(Map<String,Object> updates,Integer id);
    void delete(Integer id);
    Users findByName(String name);
}
