package com.bfi.backend.admin.services;

import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminUserDto;
import com.bfi.backend.admin.entities.AdminUser;
import com.bfi.backend.admin.mappers.AdminUserMapper;
import com.bfi.backend.admin.repository.AdminUserRepository;
import com.bfi.backend.admin.dtos.AdminCredentialsDto;
import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.repositories.UserRepository;
import com.bfi.backend.common.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;
    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminUserMapper adminUserMapper;

    public AdminUserDto login(AdminCredentialsDto adminCredentialsDto) {
        AdminUser adminUser = adminUserRepository.findByLogin(adminCredentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown admin user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(adminCredentialsDto.password()), adminUser.getPassword())) {
            return adminUserMapper.toAdminUserDto(adminUser);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public AdminUserDto register(AdminSignUpDto adminSignUpDto) {
        Optional<AdminUser> optionalAdminUser = adminUserRepository.findByLogin(adminSignUpDto.login());

        if (optionalAdminUser.isPresent()) {
            throw new AppException("Username already exists", HttpStatus.BAD_REQUEST);
        }

        AdminUser adminUser = adminUserMapper.signUpToAdminUser(adminSignUpDto);
        adminUser.setPassword(passwordEncoder.encode(CharBuffer.wrap(adminSignUpDto.password())));

        AdminUser savedAdminUser = adminUserRepository.save(adminUser);

        return adminUserMapper.toAdminUserDto(savedAdminUser);
    }

    public AdminUserDto findByLogin(String login) {
        AdminUser adminUser = adminUserRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return adminUserMapper.toAdminUserDto(adminUser);
    }


    public List<User> getAllUsers() {
        return userRepository.findByStatus(true);
    }
    /*
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
*/


    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setStatus(false);
            userRepository.save(user);
        } else {
            throw new AppException("User not found", HttpStatus.NOT_FOUND);
        }
    }
   // Assuming you have a repository for Archived_App_User


    public List<User> getAllArchivedUsers() {
        return userRepository.findByStatus(false);
    }
}
