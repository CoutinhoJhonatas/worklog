package com.git.worklog_api.config;

import com.git.worklog_api.entities.WorkSession;
import com.git.worklog_api.entities.enums.Category;
import com.git.worklog_api.repositories.WorkSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class WorkSessionSeed implements CommandLineRunner {

    private final WorkSessionRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() > 0) {
            return;
        }

        List<WorkSession> sessions = List.of(
                WorkSession.builder()
                        .title("Morning focus block")
                        .category(Category.WORK)
                        .startAt(LocalDateTime.now().minusDays(1).withHour(9))
                        .durationInMinutes(90)
                        .tags("java,spring")
                        .build(),

                WorkSession.builder()
                        .title("Worklog backend")
                        .category(Category.PROJECT)
                        .startAt(LocalDateTime.now().minusDays(1).withHour(14))
                        .durationInMinutes(60)
                        .tags("worklog,backend")
                        .build(),

                WorkSession.builder()
                        .title("Algorithms study")
                        .category(Category.STUDY)
                        .startAt(LocalDateTime.now().minusDays(2).withHour(10))
                        .durationInMinutes(45)
                        .tags("algorithms,leetcode")
                        .build(),

                WorkSession.builder()
                        .title("Refactor and cleanup")
                        .category(Category.WORK)
                        .startAt(LocalDateTime.now().minusHours(3))
                        .durationInMinutes(30)
                        .tags("refactor,cleanup")
                        .build(),

                WorkSession.builder()
                        .title("Evening review")
                        .category(Category.PERSONAL)
                        .startAt(LocalDateTime.now().minusHours(1))
                        .durationInMinutes(20)
                        .tags("reflection,planning")
                        .build(),

                WorkSession.builder()
                        .title("Worklog frontend")
                        .category(Category.PROJECT)
                        .startAt(LocalDateTime.now().minusHours(5))
                        .endAt(LocalDateTime.now().minusHours(3))
                        .tags("reflection,planning")
                        .build()
        );

        repository.saveAll(sessions);
    }
}
