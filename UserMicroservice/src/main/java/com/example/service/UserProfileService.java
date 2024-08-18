package com.example.service;

import com.example.document.UserProfile;
import com.example.dto.request.CreateUserDto;
import com.example.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

    public void createUser(CreateUserDto dto) {
        userProfileRepository.save(UserProfile.builder()
                .authId(dto.getAuthId())
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    @Cacheable("upper-case")
    public String upperName(String name) {
        String result = name.toUpperCase();
        try {
            Thread.sleep(3000L);
        }catch (Exception e) {}
        return result;
    }

    public void clearCache() {
        cacheManager.getCache("upper-case").clear();
    }
}
