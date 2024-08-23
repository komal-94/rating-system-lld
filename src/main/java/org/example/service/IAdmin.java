package org.example.service;

import org.example.models.Survey;

public interface IAdmin {
    Survey createSurvey(String title);

    void addQuestionToSurvey(String surveyId, String text, double weight);
}
