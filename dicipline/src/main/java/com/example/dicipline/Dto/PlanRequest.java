package com.example.dicipline.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PlanRequest {
    @NotNull
    private List<PhaseDto> phases;

    @Data
    public static class PhaseDto {
        private int durationDays;
        private String reward;
    }
}
