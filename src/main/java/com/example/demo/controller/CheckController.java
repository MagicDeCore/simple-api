package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CheckController {
  private final UserService userService;

  public CheckController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/check")
  public Map<String, Object> check() {
    return Map.of(
        "status", "ok",
        "message", "Mocked data response",
        "timestamp", System.currentTimeMillis()
    );
  }

  @GetMapping("/users")
  public List<UserDto> users() {
    List<UserDto> users = userService.getAllUsers();
    if (users == null || users.isEmpty()) {
      users = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        users.add(userService.createUser("Name" + i, 20+i));
      }
    }
    return users;
  }
}
