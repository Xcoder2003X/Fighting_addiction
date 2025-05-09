package com.example.dicipline.Service;

import com.example.dicipline.Dto.PlanRequest;
import com.example.dicipline.model.Phase;
import com.example.dicipline.model.Plan;
import com.example.dicipline.model.User;
import com.example.dicipline.model.Violation;
import com.example.dicipline.repository.PlanRepository;
import com.example.dicipline.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public Plan createPlan(PlanRequest planRequest, User user) {
        Plan plan = new Plan();
        plan.setUser(user);

        // Conversion des PhaseDto en Phase
        List<Phase> phases = planRequest.getPhases().stream()
                .map(dto -> new Phase(dto.getDurationDays(), dto.getReward()))
                .collect(Collectors.toList());

        plan.setPhases(phases);
        plan.setActive(true);
        plan.setCreatedDate(LocalDateTime.now());
        return planRepository.save(plan);
    }
}
