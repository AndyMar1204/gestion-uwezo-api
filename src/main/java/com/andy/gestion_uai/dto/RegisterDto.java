package com.andy.gestion_uai.dto;

import com.andy.gestion_uai.model.Role;
import com.andy.gestion_uai.model.User;
import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String email;
    private String password;
    private Role role;

    public User _convertToUser(){
        var user = new User();
        user.setRole(role);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return  user;
    }
}
