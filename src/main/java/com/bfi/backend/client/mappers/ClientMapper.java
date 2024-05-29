package com.bfi.backend.client.mappers;

import com.bfi.backend.admin.repository.AgencyRepository;
import com.bfi.backend.client.dtos.*;
import com.bfi.backend.client.entites.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AgencyRepository.class})
public interface ClientMapper {

    @Mapping(target = "password", ignore = true)
    default String mapPassword(char[] password) {
        return password != null ? new String(password) : null;
    }
    @Mapping(target = "agency.idAgency", source = "signUpDto.agencyId")
    Client signUpToClient(SignUpDto signUpDto);
    @Mapping(target = "bankAccounts", source = "Client.bankAccountList")
    @Mapping(target = "agencyId", source = "Client.agency.idAgency")
    ClientDto toClientDto(Client Client);

    BankAccountDto toBankAccountDto(BankAccount bankAccount);
    BankAccount toBankAccount(BankAccountDto bankAccountDto);

    AddressDto toAddressDto(Address address);
    Address toAddress(AddressDto addressDto); // Mapping method for AddressDto to Address

    AdditionalInfoDto toAdditionalInfoDto(AdditionalInfo additionalInfo);

    AdditionalInfo toAdditionalInfo(AdditionalInfoDto additionalInfoDto);


    //@Mapping(target = "ClientId", source = "Clientid.id")
   // BankAccountDto toBankAccountDto(BankAccount bankAccount);
    //BankAccount toBankAccount(BankAccountDto bankAccountDto);
    @Mapping(target = "agency.idAgency", source="agencyId")
    PersonnePhysique signUpToPersonnePhysique(SignUpPersonnePhysiqueDto ClientDto);
    @Mapping(target = "agency.idAgency",source="agencyId")
    PersonneMorale signUpToPersonneMorale(SignUpPersonneMoraleDto ClientDto);
    @Mapping(target = "agencyId", source = "Client.agency.idAgency")

    PersonnePhysiqueDto toPersonnePhysiqueDto(PersonnePhysique Client);
    @Mapping(target = "agencyId", source = "Client.agency.idAgency")

    PersonneMoraleDto toPersonneMoraleDto(PersonneMorale Client);

}
