package com.example.dicipline.Service;

import com.example.dicipline.Dto.BlockedSiteDto;
import com.example.dicipline.model.BlockedSite;
import com.example.dicipline.model.User;
import com.example.dicipline.repository.BlockedSiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BlockedSiteService {

    private final BlockedSiteRepository blockedSiteRepository;

    public BlockedSite addBlockedSite(BlockedSiteDto dto, User user) {
        BlockedSite site = new BlockedSite();
        site.setUser(user);
        site.setUrl(dto.getUrl());
        site.setCategory(dto.getCategory());
        site.setAddedAt(LocalDateTime.now());
        return blockedSiteRepository.save(site);
    }

    public boolean isUrlBlocked(User user, String url) {
        return blockedSiteRepository.existsByUserAndUrlContaining(user, url);
    }
}
