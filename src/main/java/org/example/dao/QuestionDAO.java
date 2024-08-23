package org.example.dao;

import org.example.models.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionDAO {
    private static QuestionDAO instance;
    private Map<String, Question> questionMap;

    private QuestionDAO() {
        questionMap = new HashMap<>();
    }

    public static synchronized QuestionDAO getInstance() {
        if (instance == null) {
            instance = new QuestionDAO();
        }
        return instance;
    }

    public void save(Question question) {
        questionMap.put(question.getId(), question);
    }

    public Question getById(String id) {
        return questionMap.get(id);
    }

}
