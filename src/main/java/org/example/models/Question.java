package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Question {
    @Getter
    private String id;
    private String text;
    @Getter
    private double weight;
}
