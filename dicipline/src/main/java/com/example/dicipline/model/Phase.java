package com.example.dicipline.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phase {
    private int durationDays;
    private String reward;
    private boolean completed;

    public Phase(int durationDays, String reward) {
        this.durationDays = durationDays;
        this.reward = reward;
    }
}
