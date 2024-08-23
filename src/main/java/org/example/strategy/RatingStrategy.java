package org.example.strategy;

import org.example.models.Survey;

public interface RatingStrategy {
    double calculate(Survey survey);
}
