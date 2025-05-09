package com.example.dicipline.Service;

import com.example.dicipline.Dto.UserRegistrationDto;
import com.example.dicipline.exception.ResourceNotFoundException;
import com.example.dicipline.model.Plan;
import com.example.dicipline.model.User;
import com.example.dicipline.model.Violation;
import com.example.dicipline.repository.PlanRepository;
import com.example.dicipline.repository.UserRepository;
import com.example.dicipline.repository.ViolationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PlanRepository planRepository;
    private final ViolationRepository violationRepository;

    public User registerUser(UserRegistrationDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }

    public void resetPlan(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Réinitialiser les statistiques
        user.setCurrentPhase(0);
        user.setPlanStartDate(null);
        user.setStreakDays(0);

        // Désactiver les anciens plans
        List<Plan> activePlans = planRepository.findByUserIdAndActiveTrue(userId);
        activePlans.forEach(plan -> {
            plan.setActive(false);
            planRepository.save(plan);
        });

        // Enregistrer la violation
        Violation violation = new Violation();
        violation.setUser(user);
        violation.setViolationTime(LocalDateTime.now());
        violationRepository.save(violation);

        userRepository.save(user);
    }

    public void updateMonitoringPing(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setLastMonitoringPing(LocalDateTime.now());
        userRepository.save(user);
    }


    @Scheduled(fixedRate = 3600000) // Toutes les heures
    public void checkForTampering() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            LocalDateTime lastPing = user.getLastMonitoringPing();

            // Gérer le cas où lastMonitoringPing est null
            if (lastPing == null) {
                logger.warn("User {} has no last monitoring ping.", user.getId());

                return; // Sortir de l'itération courante
            }

            // Vérifier l'activité de l'extension
            if (lastPing.isBefore(LocalDateTime.now().minusHours(2))) {
                resetPlan(user.getId());
                user.setTamperAttempts(user.getTamperAttempts() + 1);
                userRepository.save(user);
            }
        });}

}
