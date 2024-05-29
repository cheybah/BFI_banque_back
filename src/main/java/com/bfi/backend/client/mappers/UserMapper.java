package com.bfi.backend.client.mappers;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.admin.repository.AgencyRepository;
import com.bfi.backend.client.dtos.*;
import com.bfi.backend.client.entites.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AgencyRepository.class})
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    default String mapPassword(char[] password) {
        return password != null ? new String(password) : null;
    }
    @Mapping(target = "agency.idAgency", source = "signUpDto.agencyId")
    User signUpToUser(SignUpDto signUpDto);
    @Mapping(target = "bankAccounts", source = "user.bankAccountList")
    @Mapping(target = "agencyId", source = "user.agency.idAgency")
    UserDto toUserDto(User user);

    BankAccountDto toBankAccountDto(BankAccount bankAccount);
    BankAccount toBankAccount(BankAccountDto bankAccountDto);

    AddressDto toAddressDto(Address address);
    Address toAddress(AddressDto addressDto); // Mapping method for AddressDto to Address

    AdditionalInfoDto toAdditionalInfoDto(AdditionalInfo additionalInfo);

    AdditionalInfo toAdditionalInfo(AdditionalInfoDto additionalInfoDto);


    //@Mapping(target = "userId", source = "userid.id")
   // BankAccountDto toBankAccountDto(BankAccount bankAccount);
    //BankAccount toBankAccount(BankAccountDto bankAccountDto);
    @Mapping(target = "agency.idAgency", source="agencyId")
    PersonnePhysique signUpToPersonnePhysique(SignUpPersonnePhysiqueDto userDto);
    @Mapping(target = "agency.idAgency",source="agencyId")
    PersonneMorale signUpToPersonneMorale(SignUpPersonneMoraleDto userDto);
    @Mapping(target = "agencyId", source = "user.agency.idAgency")

    PersonnePhysiqueDto toPersonnePhysiqueDto(PersonnePhysique user);
    @Mapping(target = "agencyId", source = "user.agency.idAgency")

    PersonneMoraleDto toPersonneMoraleDto(PersonneMorale user);

}
