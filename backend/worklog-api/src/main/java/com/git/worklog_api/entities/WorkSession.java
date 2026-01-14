package com.git.worklog_api.entities;

import com.git.worklog_api.entities.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "work_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkSession {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String title;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @NotNull
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer durationInMinutes;
    private String notes;
    private String tags;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
