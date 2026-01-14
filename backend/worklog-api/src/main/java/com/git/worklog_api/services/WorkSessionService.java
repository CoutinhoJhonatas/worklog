package com.git.worklog_api.services;

import com.git.worklog_api.dtos.request.CreateWorkSessionRequest;
import com.git.worklog_api.dtos.response.WorkSessionResponse;
import com.git.worklog_api.entities.WorkSession;
import com.git.worklog_api.entities.enums.Category;
import com.git.worklog_api.repositories.WorkSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkSessionService {

    private final WorkSessionRepository workSessionRepository;

    @Transactional
    public WorkSessionResponse create(CreateWorkSessionRequest dto) {
        validateCreateRequest(dto);

        WorkSession workSession = WorkSession.builder()
                .title(dto.title())
                .category(Category.fromValue(dto.category()))
                .startAt(dto.startAt())
                .endAt(dto.durationInMinutes() == null ? dto.endAt() : null)
                .durationInMinutes(dto.durationInMinutes())
                .notes(dto.notes())
                .tags(dto.tags() != null ? String.join(",", dto.tags()) : null)
                .build();

        workSessionRepository.save(workSession);

        return buildWorkSessionResponse(workSession);
    }

    private void validateCreateRequest(CreateWorkSessionRequest dto) {
        if (dto.durationInMinutes() == null && dto.endAt() == null) {
            throw new IllegalArgumentException("endAt is required when durationMinutes is not provided");
        }
    }

    private WorkSessionResponse buildWorkSessionResponse(WorkSession workSession) {
        return WorkSessionResponse.builder()
                .id(workSession.getId().toString())
                .title(workSession.getTitle())
                .category(workSession.getCategory().toString())
                .startAt(workSession.getStartAt().toString())
                .endAt(workSession.getEndAt() != null ? workSession.getEndAt().toString() : null)
                .durationInMinutes(workSession.getDurationInMinutes())
                .notes(workSession.getNotes())
                .tags(workSession.getTags())
                .build();
    }
}
