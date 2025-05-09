package com.example.dicipline.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserRegistrationDto { // Retirer @Entity
    private String email;
    private String password;
    private LocalDateTime lastMonitoringPing;
}

