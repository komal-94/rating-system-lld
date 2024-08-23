package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
public class UserResponse {
    private final String user_id;
    @Getter
    private final Survey survey;
    @Getter
    private final Map<Question, Double> answers;
}
