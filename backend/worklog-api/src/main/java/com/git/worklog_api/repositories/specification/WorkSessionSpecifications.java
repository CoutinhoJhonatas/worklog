package com.git.worklog_api.repositories.specification;

import com.git.worklog_api.entities.WorkSession;
import com.git.worklog_api.entities.enums.Category;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class WorkSessionSpecifications {

    private WorkSessionSpecifications() {
    }

    public static Specification<WorkSession> hasCategory(Category category) {
        return (root, query, criteriaBuilder) -> {
            if (category == null) return null;
            return criteriaBuilder.equal(root.get("category"), category);
        };
    }

    public static Specification<WorkSession> startAtBetween(LocalDateTime from, LocalDateTime to) {
        return (root, query, criteriaBuilder) -> {
            if (from == null && to == null) return null;

            if (from != null && to != null) {
                return criteriaBuilder.between(root.get("startAt"), from, to);
            }

            if (from != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("startAt"), from);
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("startAt"), to);
        };
    }

    public static Specification<WorkSession> hasTag(String tag) {
        return (root, query, criteriaBuilder) -> {
            if (tag == null || tag.isBlank()) return null;

            String pattern = "%" + tag.trim().toLowerCase() + "%";
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("tags")), pattern);
        };
    }
}
