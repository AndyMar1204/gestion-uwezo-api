package com.andy.gestion_uai.service;

import com.andy.gestion_uai.model.User;
import com.andy.gestion_uai.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    public User currentUser(){
        var auth =SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();
    }

    public List<User> allUsers(){
        return repository.findAll();
    }
}
