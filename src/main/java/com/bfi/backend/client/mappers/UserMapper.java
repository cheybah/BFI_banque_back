package com.bfi.backend.client.mappers;

import com.bfi.backend.admin.repository.AgencyRepository;
import com.bfi.backend.client.dtos.AdditionalInfoDto;
import com.bfi.backend.client.dtos.AddressDto;
import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AgencyRepository.class})
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "agency.idAgency", source = "signUpDto.agencyId")
    User signUpToUser(SignUpDto signUpDto);
    @Mapping(target = "agencyId", source = "user.agency.idAgency")
    UserDto toUserDto(User user);

    AddressDto toAddressDto(Address address);
    Address toAddress(AddressDto addressDto); // Mapping method for AddressDto to Address

    AdditionalInfoDto toAdditionalInfoDto(AdditionalInfo additionalInfo);

    AdditionalInfo toAdditionalInfo(AdditionalInfoDto additionalInfoDto);

}
