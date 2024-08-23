package org.example.strategy;

import org.example.dao.UserResponseDAO;
import org.example.models.Question;
import org.example.models.Survey;
import org.example.models.UserResponse;

import java.util.List;
import java.util.Map;

public class SimpleRatingStrategy implements RatingStrategy {
    @Override
    public double calculate(Survey survey) {
        List<UserResponse> userResponseList = UserResponseDAO.getInstance().getResponsesBySurvey(survey);

        if (userResponseList == null || userResponseList.isEmpty()) {
            throw new RuntimeException("No responses have been submitted");
        }

        double totScore = 0;
        int count = 0;

        for(UserResponse userResponse : userResponseList) {
            for (Map.Entry<Question, Double> entry: userResponse.getAnswers().entrySet()) {
                totScore += entry.getValue() * entry.getKey().getWeight();
                count++;
            }
        }

        return count == 0 ? 0 : totScore / count;
    }
}
