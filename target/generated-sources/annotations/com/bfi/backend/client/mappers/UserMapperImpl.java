package com.bfi.backend.client.mappers;

import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.UserDto;
import com.bfi.backend.client.entites.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-10T21:01:54+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.gender( user.getGender() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.photo( user.getPhoto() );
        userDto.email( user.getEmail() );
        userDto.phoneNumber( user.getPhoneNumber() );
        userDto.dateOfBirth( user.getDateOfBirth() );
        userDto.login( user.getLogin() );

        return userDto.build();
    }

    @Override
    public User signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.gender( signUpDto.gender() );
        user.firstName( signUpDto.firstName() );
        user.lastName( signUpDto.lastName() );
        user.photo( signUpDto.photo() );
        user.email( signUpDto.email() );
        user.phoneNumber( signUpDto.phoneNumber() );
        user.dateOfBirth( signUpDto.dateOfBirth() );
        user.login( signUpDto.login() );

        return user.build();
    }
}
