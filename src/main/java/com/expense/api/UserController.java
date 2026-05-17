package com.expense.api;

import com.expense.api.dto.UserDto;
import com.expense.model.User;
import com.expense.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "User management endpoints")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new user")
    public UserDto createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.email(), request.passwordHash());
        return new UserDto(user.getUserId(), user.getEmail(), user.isVerified());
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get user by ID")
    public UserDto getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return new UserDto(user.getUserId(), user.getEmail(), user.isVerified());
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(u -> new UserDto(u.getUserId(), u.getEmail(), u.isVerified()))
                .collect(Collectors.toList());
    }

    record CreateUserRequest(String email, String passwordHash) {}
}
