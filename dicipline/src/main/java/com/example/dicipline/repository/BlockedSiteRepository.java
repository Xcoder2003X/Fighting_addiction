package com.example.dicipline.repository;

import com.example.dicipline.model.BlockedSite;
import com.example.dicipline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlockedSiteRepository extends JpaRepository<BlockedSite, Long> {
    boolean existsByUserAndUrlContaining(User user, String url);
    List<BlockedSite> findByUser(User user);
}
