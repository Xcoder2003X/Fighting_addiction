package com.example.dicipline.Controller;

import com.example.dicipline.Dto.PlanRequest;
import com.example.dicipline.Service.PlanService;
import com.example.dicipline.model.Plan;
import com.example.dicipline.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public ResponseEntity<Plan> createPlan(@RequestBody PlanRequest request,
                                           @AuthenticationPrincipal User user) {
        Plan plan = planService.createPlan(request, user);
        return ResponseEntity.ok(plan);
    }
}
