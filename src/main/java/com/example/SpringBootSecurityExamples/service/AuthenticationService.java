package com.example.SpringBootSecurityExamples.service;

import com.example.SpringBootSecurityExamples.config.JwtService;
import com.example.SpringBootSecurityExamples.enums.Role;
import com.example.SpringBootSecurityExamples.model.AuthenticationRequest;
import com.example.SpringBootSecurityExamples.model.AuthenticationResponse;
import com.example.SpringBootSecurityExamples.model.RegisterRequest;
import com.example.SpringBootSecurityExamples.model.User;
import com.example.SpringBootSecurityExamples.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
//        try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//            System.out.println(ex.getStackTrace());
//        }


        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
