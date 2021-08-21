package com.assignment.service;

import com.assignment.dto.UserDto;
import com.assignment.dto.UserForGetDto;
import java.util.List;

public interface UserService {

  UserForGetDto getUserById(Long id);

  void createUser(UserDto userDto);

  void updateUser(Long id, UserDto userDto);

  void deleteUser(Long id);

  List<UserForGetDto> getAll();
}
