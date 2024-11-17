package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naimix.model.UserFilterRequest;
import ru.naimix.model.UserRequest;
import ru.naimix.model.UserResponse;
import ru.naimix.model.UsersResponse;
import ru.naimix.service.UserService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/filter")
    public ResponseEntity<UsersResponse> filter(@RequestBody(required = false) UserFilterRequest userFilterRequest){
        var usersResponse = userService.filter(userFilterRequest);
        return new ResponseEntity<>(usersResponse, OK);
    }
    @GetMapping("/all")
    public ResponseEntity<UsersResponse> getAll() {
        var usersResponse = userService.getAll();
        return new ResponseEntity<>(usersResponse, OK);
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest){
        var userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") Long userId){
        userService.delete(userId);
        return new ResponseEntity<>(NO_CONTENT);
    }
    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponse> update(@PathVariable("userId") Long userId, @RequestBody UserRequest userRequest){
        var userResponse = userService.update(userId, userRequest);
        return new ResponseEntity<>(userResponse, OK);
    }
}
