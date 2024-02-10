package com.bfi.backend.mappers;

import com.bfi.backend.dtos.SignUpDto;
import com.bfi.backend.dtos.UserDto;
import com.bfi.backend.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
