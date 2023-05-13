package com.rajdubey.jwtRAJ.controllers;

import com.rajdubey.jwtRAJ.entites.UserEntity;
import com.rajdubey.jwtRAJ.models.LoginRequest;
import com.rajdubey.jwtRAJ.repos.UserRepository;
import com.rajdubey.jwtRAJ.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtTokenProvider;

    @PostMapping
    public ResponseEntity<?> generateToken(@RequestBody LoginRequest loginRequest) {
        try {

            //check here if user is valid or not
            Map<String, Object> res = new HashMap<>();

            UserEntity user = userRepository.findByUsernameIgnoreCase(loginRequest.username()).orElse(null);
            if (user == null || (!user.getPassword().equals(loginRequest.password()))) {
                res.put("success", false);
                res.put("message", "Auth failed "
                        + user);
                return ResponseEntity.ok(res);
            }


            res.put("success", true);
            String token = jwtTokenProvider.generateToken(loginRequest.username());
            res.put("token", token);
            res.put("roles", user.getRoles());
            return ResponseEntity.ok(res);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
