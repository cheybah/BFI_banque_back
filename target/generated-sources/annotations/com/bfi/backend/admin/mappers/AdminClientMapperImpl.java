package com.bfi.backend.admin.mappers;

import com.bfi.backend.admin.dtos.AdminClientDto;
import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.entities.AdminClient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
<<<<<<< HEAD
    date = "2024-06-07T12:01:31+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
=======
=======
>>>>>>> main
    date = "2024-06-06T19:50:50+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
>>>>>>> 3cecb55c9ab700d0d4606e43bc14fc37fcce7936
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
