package org.example.dao;

import org.example.models.Survey;

import java.util.HashMap;
import java.util.Map;

public class SurveyDAO {
    private static SurveyDAO instance;
    private Map<String, Survey> surveyMap;

    private SurveyDAO() {
        surveyMap = new HashMap<>();
    }

    public static synchronized SurveyDAO getInstance() {
        if (instance == null) {
            instance = new SurveyDAO();
        }
        return instance;
    }

    public void save(Survey survey) {
        surveyMap.put(survey.getId(), survey);
    }

    public Survey getById(String id) {
        return surveyMap.get(id);
    }

}
