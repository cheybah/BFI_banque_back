package com.bfi.backend.admin.mappers;

import com.bfi.backend.admin.dtos.AdminClientDto;
import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.entities.AdminClient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T18:33:08+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class AdminClientMapperImpl implements AdminClientMapper {

    @Override
    public AdminClientDto toAdminClientDto(AdminClient adminClient) {
        if ( adminClient == null ) {
            return null;
        }

        AdminClientDto.AdminClientDtoBuilder adminClientDto = AdminClientDto.builder();

        adminClientDto.id( adminClient.getId() );
        adminClientDto.firstName( adminClient.getFirstName() );
        adminClientDto.lastName( adminClient.getLastName() );
        adminClientDto.email( adminClient.getEmail() );
        adminClientDto.login( adminClient.getLogin() );
        adminClientDto.role( adminClient.getRole() );

        return adminClientDto.build();
    }

    @Override
    public AdminClient signUpToAdminClient(AdminSignUpDto adminSignUpDto) {
        if ( adminSignUpDto == null ) {
            return null;
        }

        AdminClient.AdminClientBuilder adminClient = AdminClient.builder();

        adminClient.firstName( adminSignUpDto.firstName() );
        adminClient.lastName( adminSignUpDto.lastName() );
        adminClient.email( adminSignUpDto.email() );
        adminClient.login( adminSignUpDto.login() );
        adminClient.role( adminSignUpDto.role() );

        return adminClient.build();
    }
}
