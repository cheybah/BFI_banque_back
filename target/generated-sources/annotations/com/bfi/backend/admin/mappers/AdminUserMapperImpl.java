package com.bfi.backend.admin.mappers;

import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminUserDto;
import com.bfi.backend.admin.entities.AdminUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-07T08:46:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class AdminUserMapperImpl implements AdminUserMapper {

    @Override
    public AdminUserDto toAdminUserDto(AdminUser adminUser) {
        if ( adminUser == null ) {
            return null;
        }

        AdminUserDto.AdminUserDtoBuilder adminUserDto = AdminUserDto.builder();

        adminUserDto.id( adminUser.getId() );
        adminUserDto.firstName( adminUser.getFirstName() );
        adminUserDto.lastName( adminUser.getLastName() );
        adminUserDto.email( adminUser.getEmail() );
        adminUserDto.login( adminUser.getLogin() );
        adminUserDto.role( adminUser.getRole() );

        return adminUserDto.build();
    }

    @Override
    public AdminUser signUpToAdminUser(AdminSignUpDto adminSignUpDto) {
        if ( adminSignUpDto == null ) {
            return null;
        }

        AdminUser.AdminUserBuilder adminUser = AdminUser.builder();

        adminUser.firstName( adminSignUpDto.firstName() );
        adminUser.lastName( adminSignUpDto.lastName() );
        adminUser.email( adminSignUpDto.email() );
        adminUser.login( adminSignUpDto.login() );
        adminUser.role( adminSignUpDto.role() );

        return adminUser.build();
    }
}
