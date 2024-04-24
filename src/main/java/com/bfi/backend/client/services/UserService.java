package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.*;
import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.mappers.UserMapper;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.common.exceptions.AppException;
import com.bfi.backend.client.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BankAccountRepository bankAccountRepository;

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
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        // Create and save the address
        Address address = new Address();
        // Set address properties
        address.setCountry(userDto.address().getCountry());
        address.setCity(userDto.address().getCity());
        address.setNeighbourhood(userDto.address().getNeighbourhood());
        address.setZipCode(userDto.address().getZipCode());
        // Associate address with the user
        user.setAddress(address);
        address.setUser(user);  //save user_id in address

        // Create and save additional information
        AdditionalInfo additionalInfo = new AdditionalInfo();
        // Populate additionalInfo fields as needed
        additionalInfo.setTypeIndividual(userDto.additionalInfo().getTypeIndividual());
        additionalInfo.setProfession(userDto.additionalInfo().getProfession());
        additionalInfo.setPieceType(userDto.additionalInfo().getPieceType());
        additionalInfo.setPieceNumber(userDto.additionalInfo().getPieceNumber());
        additionalInfo.setExpirationDate(userDto.additionalInfo().getExpirationDate());
        additionalInfo.setPiecePhoto(userDto.additionalInfo().getPiecePhoto());
        additionalInfo.setReferralCode(userDto.additionalInfo().getReferralCode());
        // Associate additionalInfo with the user
        user.setAdditionalInfo(additionalInfo);
        additionalInfo.setUser(user);

        User savedUser = userRepository.save(user);


        System.out.println("id 4user"+user.getId());

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


   public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }




    public boolean checkEmailExistence(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
