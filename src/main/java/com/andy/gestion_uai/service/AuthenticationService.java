package com.andy.gestion_uai.service;

import com.andy.gestion_uai.dto.AuthenticationResponse;
import com.andy.gestion_uai.dto.LoginDto;
import com.andy.gestion_uai.dto.RegisterDto;
import com.andy.gestion_uai.model.User;
import com.andy.gestion_uai.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterDto req) {
        if (userRepository.findByEmail(req.getEmail()).isPresent())
            return new AuthenticationResponse(null, "L'adresse email est deja utilisé par un autre utilisateur");
        var user = req._convertToUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        var token = jwtService.generateToken(savedUser);
        return new AuthenticationResponse(token, "Enregistrement reussie");
    }

    public AuthenticationResponse login(LoginDto req) throws Exception {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );
        if (auth.isAuthenticated()) {
            var user = (UserDetails) auth.getPrincipal();
            var jwt = jwtService.generateToken(user);
            return new AuthenticationResponse(jwt, "Connexion reussie");
        } else
            throw new UsernameNotFoundException("Email ou mot de passe incorrect");
    }

}
