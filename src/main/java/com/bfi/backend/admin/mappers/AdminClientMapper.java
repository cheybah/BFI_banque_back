package com.bfi.backend.admin.mappers;

import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminClientDto;
import com.bfi.backend.admin.entities.AdminClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminClientMapper {

    AdminClientDto toAdminClientDto(AdminClient adminClient);

    @Mapping(target = "password", ignore = true)
    AdminClient signUpToAdminClient(AdminSignUpDto adminSignUpDto);

}
