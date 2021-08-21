package com.assignment.mapper;

import com.assignment.dao.entity.UserEntity;
import com.assignment.dto.UserDto;
import com.assignment.dto.UserForGetDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-21T08:43:07+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserForGetDto convertFrom(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserForGetDto userForGetDto = new UserForGetDto();

        userForGetDto.setId( userEntity.getId() );
        userForGetDto.setName( userEntity.getName() );
        userForGetDto.setPhone( userEntity.getPhone() );

        return userForGetDto;
    }

    @Override
    public UserEntity convertTo(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName( userDto.getName() );
        userEntity.setPhone( userDto.getPhone() );

        return userEntity;
    }

    @Override
    public UserEntity merge(UserDto userDto, UserEntity userEntity) {
        if ( userDto == null ) {
            return null;
        }

        if ( userDto.getName() != null ) {
            userEntity.setName( userDto.getName() );
        }
        if ( userDto.getPhone() != null ) {
            userEntity.setPhone( userDto.getPhone() );
        }

        return userEntity;
    }
}
