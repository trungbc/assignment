package com.assignment.mapper;


import com.assignment.dao.entity.UserEntity;
import com.assignment.dto.UserDto;
import com.assignment.dto.UserForGetDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserForGetDto convertFrom(UserEntity userEntity);

  UserEntity convertTo(UserDto userDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
      nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  UserEntity merge(UserDto userDto, @MappingTarget UserEntity userEntity);


}
