package com.example.SpringBootSecurityExamples.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class AuthenticationRequest {
    private String email;
    private String password;
}
