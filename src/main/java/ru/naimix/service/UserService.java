package ru.naimix.service;

import ru.naimix.domain.entity.User;
import ru.naimix.model.UserFilterRequest;
import ru.naimix.model.UserRequest;
import ru.naimix.model.UserResponse;
import ru.naimix.model.UsersResponse;

public interface UserService {
    UsersResponse filter(UserFilterRequest userFilterRequest);

    UserResponse create(UserRequest userRequest);

    void delete(Long userId);

    UserResponse update(Long userId, UserRequest userRequest);

    User getById(Long userIdFromRequest);
}
