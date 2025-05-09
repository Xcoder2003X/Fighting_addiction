package com.example.dicipline.Service;

import com.example.dicipline.exception.ResourceNotFoundException;
import com.example.dicipline.model.User;
import com.example.dicipline.model.Violation;
import com.example.dicipline.repository.BlockedSiteRepository;
import com.example.dicipline.repository.UserRepository;
import com.example.dicipline.repository.ViolationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentMonitoringService {

    private final BlockedSiteRepository blockedSiteRepository;
    private final UserRepository userRepository;
    private final ViolationRepository violationRepository; // Ajout

    // Méthode appelée par l'extension navigateur
    public void checkForViolation(String url, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean isBlocked = blockedSiteRepository.existsByUserAndUrlContaining(user, url);

        if(isBlocked) {

            // Enregistrement de la violation
            Violation violation = new Violation();
            violation.setUser(user);
            violation.setViolationTime(LocalDateTime.now());
            violation.setAccessedUrl(url);
            violationRepository.save(violation);

            // Mise à jour du compteur
            user.setTotalViolations(user.getTotalViolations() + 1);
            userRepository.save(user);
        }
    }

    // Dans ContentMonitoringService.java



}
