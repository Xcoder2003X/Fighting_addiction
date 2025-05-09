package com.example.dicipline.Controller;

import com.example.dicipline.Dto.BlockedSiteDto;
import com.example.dicipline.Service.BlockedSiteService;
import com.example.dicipline.model.BlockedSite;
import com.example.dicipline.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blocked-sites")
@RequiredArgsConstructor
public class BlockedSiteController {

    private final BlockedSiteService blockedSiteService;

    @PostMapping
    public ResponseEntity<BlockedSite> addBlockedSite(@RequestBody BlockedSiteDto dto,
                                                      @AuthenticationPrincipal User user) {
        BlockedSite site = blockedSiteService.addBlockedSite(dto, user);
        return ResponseEntity.ok(site);
    }
}
