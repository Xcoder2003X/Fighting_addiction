package com.example.dicipline.repository;

import com.example.dicipline.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByUserId(Long userId);
    List<Plan> findByUserIdAndActiveTrue(Long userId); // Ajout de la méthode manquante

}
