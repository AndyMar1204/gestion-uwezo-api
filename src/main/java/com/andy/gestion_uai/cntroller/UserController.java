package com.andy.gestion_uai.cntroller;

import com.andy.gestion_uai.model.User;
import com.andy.gestion_uai.service.UserService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService service;

    @GetMapping("me")
    public ResponseEntity<User> me(){
        return ResponseEntity.ok(service.currentUser());
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity.ok(service.allUsers());
    }
}
