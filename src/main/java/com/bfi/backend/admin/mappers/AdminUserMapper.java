package com.bfi.backend.admin.mappers;

import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminUserDto;
import com.bfi.backend.admin.entities.AdminUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminUserMapper {

    AdminUserDto toAdminUserDto(AdminUser adminUser);

    @Mapping(target = "password", ignore = true)
    AdminUser signUpToAdminUser(AdminSignUpDto adminSignUpDto);

}
