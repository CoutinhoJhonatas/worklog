package com.git.worklog_api.controllers;

import com.git.worklog_api.dtos.request.CreateWorkSessionRequest;
import com.git.worklog_api.dtos.response.WorkSessionResponse;
import com.git.worklog_api.services.WorkSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class WorkSessionController {

    private final WorkSessionService workSessionService;

    @PostMapping
    public ResponseEntity<WorkSessionResponse> create(@Valid @RequestBody CreateWorkSessionRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(workSessionService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<WorkSessionResponse>> listAll() {
        return ResponseEntity.ok(workSessionService.listAll());
    }

}
