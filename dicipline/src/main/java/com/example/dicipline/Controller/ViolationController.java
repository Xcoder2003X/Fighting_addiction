package com.example.dicipline.Controller;

import com.example.dicipline.Service.ContentMonitoringService;
import com.example.dicipline.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/violations")
@RequiredArgsConstructor
public class ViolationController {

    private final ContentMonitoringService monitoringService;

    @PostMapping("/check")
    public ResponseEntity<?> checkUrl(@RequestBody UrlCheckRequest request,
                                      @AuthenticationPrincipal User user) {
        monitoringService.checkForViolation(request.getUrl(), user.getId());
        return ResponseEntity.ok().build();
    }

    @Data
    public static class UrlCheckRequest {
        private String url;
    }
}
