package com.git.worklog_api.entities.enums;

import java.util.Arrays;

public enum Category {
    WORK,
    STUDY,
    PROJECT,
    PERSONAL;

    public static Category fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        return Arrays.stream(values())
                .filter(category -> category.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category: " + value));
    }
}
