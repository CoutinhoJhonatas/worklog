package com.git.worklog_api.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkSessionResponse {

    private String id;
    private String title;
    private String category;
    private String startAt;
    private String endAt;
    private Integer durationInMinutes;
    private String notes;
    private String tags;
}
