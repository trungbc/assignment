package com.assignment.service.impl;

import com.assignment.dao.entity.UserEntity;
import com.assignment.dao.repository.UserRepository;
import com.assignment.dto.UserDto;
import com.assignment.dto.UserForGetDto;
import com.assignment.mapper.UserMapper;
import com.assignment.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  final UserRepository userRepo;

  final UserMapper userMapper;

  @Override
  public UserForGetDto getUserById(Long id) {
    Optional<UserEntity> userEntity = userRepo.findById(id);
    UserEntity user = userEntity
        .orElseThrow(() -> new EntityNotFoundException("Cannot find id : " + id));

    return userMapper.convertFrom(user);
  }

  @Override
  public void createUser(UserDto userDto) {
    UserEntity userEntity = userMapper.convertTo(userDto);
    userRepo.save(userEntity);
  }

  @Override
  public void updateUser(Long id, UserDto userDto) {
    Optional<UserEntity> userEntity = userRepo.findById(id);
    UserEntity user = userEntity
        .orElseThrow(() -> new EntityNotFoundException("Cannot find id : " + id));
    user = userMapper.merge(userDto, user);
    userRepo.save(user);
  }

  @Override
  public void deleteUser(Long id) {
    Optional<UserEntity> userEntity = userRepo.findById(id);
    UserEntity user = userEntity
        .orElseThrow(() -> new EntityNotFoundException("Cannot find id : " + id));
    userRepo.delete(user);
  }

  @Override
  public List<UserForGetDto> getAll() {
    Iterable<UserEntity> users = userRepo.findAll();
    List<UserForGetDto> result = new ArrayList<>();
    users.forEach(userEntity -> {
      result.add(userMapper.convertFrom(userEntity));
    });

    return result;
  }
}
