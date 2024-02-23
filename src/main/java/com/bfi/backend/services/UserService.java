package com.bfi.backend.services;

import com.bfi.backend.dtos.CredentialsDto;
import com.bfi.backend.dtos.SignUpDto;
import com.bfi.backend.dtos.UserDto;
import com.bfi.backend.entites.User;
import com.bfi.backend.exceptions.AppException;
import com.bfi.backend.mappers.UserMapper;
import com.bfi.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public void resetPassword(String login, String newPassword) {
        // Encrypt the new password
        String encryptedPassword = passwordEncoder.encode(newPassword);

        // Retrieve the user by login
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("User with provided login does not exist", HttpStatus.NOT_FOUND));

        // Update the user's password with the encrypted one
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }
    public boolean checkEmailExistence(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
