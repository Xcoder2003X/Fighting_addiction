package com.example.dicipline.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BlockedSiteDto {
    @NotBlank
    private String url;

    @NotBlank
    private String category;
}
