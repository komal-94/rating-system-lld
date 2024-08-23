package org.example.dao;

import org.example.models.Survey;
import org.example.models.UserResponse;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResponseDAO {
    private static UserResponseDAO instance;
    private Map<String, List<UserResponse>> responseMap;

    private UserResponseDAO() {
        responseMap = new HashMap<>();
    }

    public static synchronized UserResponseDAO getInstance() {
        if (instance == null) {
            instance = new UserResponseDAO();
        }
        return instance;
    }

    public void save(UserResponse response) {
        responseMap.computeIfAbsent(response.getSurvey().getId(), k->new ArrayList<>()).add(response);
    }

    public List<UserResponse> getResponsesBySurvey(Survey survey) {
        return responseMap.getOrDefault(survey.getId(), new ArrayList<>());
    }

}
