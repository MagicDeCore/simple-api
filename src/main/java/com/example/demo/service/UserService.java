package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDto createUser(String name, Integer age) {
    UserEntity userEntity = userRepository.save(new UserEntity(name, age));
    return new UserDto(userEntity.getId(), userEntity.getName(), userEntity.getAge());
  }

  public List<UserDto> getAllUsers() {
    return userRepository.findAllByAgeExists().stream()
        .map(u -> new UserDto(u.getId(), u.getName(), u.getAge()))
        .collect(Collectors.toList());
  }
}
