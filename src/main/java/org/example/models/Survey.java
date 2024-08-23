package org.example.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    @Getter
    private String id;
    private String title;
    @Getter
    private List<Question> questions;

    public Survey(String id, String title) {
        this.id = id;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }
}
