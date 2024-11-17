package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naimix.domain.entity.Role;
import ru.naimix.domain.entity.User;
import ru.naimix.mapper.UserMapper;
import ru.naimix.model.UserFilterRequest;
import ru.naimix.model.UserRequest;
import ru.naimix.model.UserResponse;
import ru.naimix.model.UsersResponse;
import ru.naimix.repository.UserRepository;
import ru.naimix.service.UserService;

import java.util.HashSet;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public UsersResponse filter(UserFilterRequest userFilterRequest) {
        var role = getRoleFromRequest(userFilterRequest);
        var userFromRepository = userRepository.filter(role);
        var usersForResponse = userMapper.toUserResponseList(userFromRepository);
        var usersResponse = new UsersResponse();
        usersResponse.content(usersForResponse);
        return usersResponse;
    }

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest) {
        var userFromRequest = userMapper.toUser(userRequest);
        var userWithRoles = setUserRole(userFromRequest);
        var userSave = userRepository.saveAndFlush(userWithRoles);
        return userMapper.toUserResponse(userSave);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse update(Long userId, UserRequest userRequest) {
        var userFind = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден!"));
        var updateUser = userMapper.update(userFind, userRequest);
        var saveAndFlush = userRepository.saveAndFlush(updateUser);
        return userMapper.toUserResponse(saveAndFlush);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long userIdFromRequest) {
        return userRepository.findById(userIdFromRequest)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найдена в БД"));
    }

    @Override
    public UsersResponse getAll() {
        var usersFromRepository = userRepository.findAll();
        var usersForResponse = userMapper.toUserResponseList(usersFromRepository);
        var usersResponse = new UsersResponse();
        usersResponse.content(usersForResponse);
        return usersResponse;
    }

    private User setUserRole(User userFromRequest) {
        HashSet<Role> roles = new HashSet<>();
        Role employeeRole = new Role();
        employeeRole.setName("EMPLOYEE");
        roles.add(employeeRole);
        userFromRequest.setRoles(roles);
        return userFromRequest;
    }

    private static String getRoleFromRequest(UserFilterRequest userFilterRequest) {
        if (isNull(userFilterRequest)) {
            userFilterRequest = new UserFilterRequest();
        }
        return Optional.ofNullable(userFilterRequest.getRole())
                .orElse(null);
    }
}
