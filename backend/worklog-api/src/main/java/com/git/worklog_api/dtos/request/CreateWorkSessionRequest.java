package com.git.worklog_api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record CreateWorkSessionRequest(
        @NotBlank String title,
        @NotNull String category,
        @NotNull LocalDateTime startAt,
        LocalDateTime endAt,
        String notes,
        Integer durationInMinutes,
        List<String> tags
) {}
