package com.assignment.controller;

import com.assignment.dto.UserDto;
import com.assignment.dto.UserForGetDto;
import com.assignment.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

  final UserService userSerivce;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Map<String, List> getAllUser() {
    Map<String, List> result = new HashMap<>();
    result.put("data", userSerivce.getAll());
    return result;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserForGetDto getUser(@PathVariable Long id) {
    UserForGetDto userDto = userSerivce.getUserById(id);
    return userDto;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@RequestBody @Valid UserDto userDto) {
    userSerivce.createUser(userDto);
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
    userSerivce.updateUser(id, userDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteUser(@PathVariable Long id) {
    userSerivce.deleteUser(id);
  }

}
