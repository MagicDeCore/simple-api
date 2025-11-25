package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CheckController {

  @GetMapping("/check")
  public Map<String, Object> check() {
    return Map.of(
        "status", "ok",
        "message", "Mocked data response",
        "timestamp", System.currentTimeMillis()
    );
  }
}
