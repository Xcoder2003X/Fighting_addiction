package com.example.dicipline.repository;

import com.example.dicipline.model.User;
import com.example.dicipline.model.Violation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ViolationRepository extends JpaRepository<Violation, Long> {
    List<Violation> findByUserOrderByViolationTimeDesc(User user);
}
