package org.example.service;

import org.example.models.Survey;
import org.example.strategy.RatingStrategy;

public class RatingService {
    private final RatingStrategy ratingStrategy;

    public RatingService(RatingStrategy ratingStrategy) {
        this.ratingStrategy = ratingStrategy;
    }

    public double calculateRating(Survey survey) {
        return ratingStrategy.calculate(survey);
    }
}
