package com.git.worklog_api.controllers;

import com.git.worklog_api.dtos.request.CreateWorkSessionRequest;
import com.git.worklog_api.dtos.response.WorkSessionResponse;
import com.git.worklog_api.services.WorkSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class WorkSessionController {

    private final WorkSessionService workSessionService;

    @PostMapping
    public ResponseEntity<WorkSessionResponse> create(@Valid @RequestBody CreateWorkSessionRequest request) {
        return new ResponseEntity<>(workSessionService.create(request), HttpStatus.CREATED);
    }

}
