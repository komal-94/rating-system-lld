package org.example.service;

import org.example.dao.UserResponseDAO;
import org.example.models.UserResponse;

public class UserResponseService implements IUserResponse {
    UserResponseDAO userResponseDAO = UserResponseDAO.getInstance();
    @Override
    public void submitResponse(UserResponse userResponse) {
        userResponseDAO.save(userResponse);
    }
}
