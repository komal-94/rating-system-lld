package org.example;

import org.example.models.Question;
import org.example.models.Survey;
import org.example.models.UserResponse;
import org.example.service.AdminService;
import org.example.service.RatingService;
import org.example.service.UserResponseService;
import org.example.strategy.SimpleRatingStrategy;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        UserResponseService userResponseService = new UserResponseService();
        RatingService ratingService = new RatingService(new SimpleRatingStrategy());

        Survey s1 = adminService.createSurvey("New test");
        adminService.addQuestionToSurvey(s1.getId(), "Q1", 3.0);
        adminService.addQuestionToSurvey(s1.getId(), "Q2", 2.0);
        adminService.addQuestionToSurvey(s1.getId(), "Q3", 1.5);
        adminService.addQuestionToSurvey(s1.getId(), "Q4", 1.3);
        adminService.addQuestionToSurvey(s1.getId(), "Q5", 2);

        Map<Question, Double> answers1 = new HashMap<>();

        for (Question q:s1.getQuestions()) {
            answers1.put(q, 2.0);
        }
        UserResponse r1 = new UserResponse("user_1", s1, answers1);

        userResponseService.submitResponse(r1);

        Map<Question, Double> answers2 = new HashMap<>();

        for (Question q:s1.getQuestions()) {
            answers2.put(q, 3.0);
        }
        UserResponse r2 = new UserResponse("user_2", s1, answers2);

        userResponseService.submitResponse(r2);

        double final_ans = ratingService.calculateRating(s1);
        System.out.println("Final ans: " + final_ans);

    }
}