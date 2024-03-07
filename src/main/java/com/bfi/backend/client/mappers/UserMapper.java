package com.bfi.backend.client.mappers;

import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
