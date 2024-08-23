package org.example.service;

import org.example.dao.QuestionDAO;
import org.example.dao.SurveyDAO;
import org.example.models.Question;
import org.example.models.Survey;

public class AdminService implements IAdmin {
    private final SurveyDAO surveyDAO = SurveyDAO.getInstance();
    private final QuestionDAO questionDAO = QuestionDAO.getInstance();

    @Override
    public Survey createSurvey(String title) {
        Survey survey = new Survey(java.util.UUID.randomUUID().toString(), title);
        surveyDAO.save(survey);
        return survey;
    }

    @Override
    public void addQuestionToSurvey(String surveyId, String text, double weight) {
        Survey survey = surveyDAO.getById(surveyId);
        if (survey == null) {
            throw new RuntimeException("Survey not found " + surveyId);
        }
        Question q = new Question(java.util.UUID.randomUUID().toString(), text, weight);
        survey.addQuestion(q);
        questionDAO.save(q);
    }
}
