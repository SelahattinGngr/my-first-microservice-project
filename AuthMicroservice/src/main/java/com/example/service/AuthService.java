package com.example.service;

import com.example.dto.request.CreateUserDto;
import com.example.dto.request.LoginResponseDto;
import com.example.dto.request.RegisterRequestDto;
import com.example.entitiy.Auth;
import com.example.manager.UserProfileManager;
import com.example.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = authRepository.save(Auth.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail()).build());
        userProfileManager.createUser(CreateUserDto.builder()
                        .authId(auth.getId())
                        .userName(auth.getUsername())
                        .email(auth.getEmail())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return authRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword()).isPresent();
    }
}
