package com.helpnest.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser {
    private Long userId;
    private String username;
    private String role;
    private Long groupId;
}
