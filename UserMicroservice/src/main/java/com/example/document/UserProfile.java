package com.example.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class UserProfile {
    String id;
    Long authId;
    String userName;
    String name;
    String surname;
    String email;
    String phone;
    String avatar;
    String insta;
    String twitter;
    boolean isActive;
    Long createdAt;
}
