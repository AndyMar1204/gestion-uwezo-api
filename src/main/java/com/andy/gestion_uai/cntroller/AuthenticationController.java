package com.andy.gestion_uai.cntroller;

import com.andy.gestion_uai.dto.AuthenticationResponse;
import com.andy.gestion_uai.dto.LoginDto;
import com.andy.gestion_uai.dto.RegisterDto;
import com.andy.gestion_uai.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> addNewUser(@RequestBody RegisterDto req){
        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto req){
        try {
            return ResponseEntity.ok(authService.login(req));
        }catch (Exception ex){
            return new ResponseEntity<>(new AuthenticationResponse(null,ex.getMessage()), HttpStatus.GONE);
        }
    }
}
