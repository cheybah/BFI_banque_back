package com.bfi.backend.client.mappers;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.client.dtos.AdditionalInfoDto;
import com.bfi.backend.client.dtos.AdditionalInfoMoralDto;
import com.bfi.backend.client.dtos.AddressDto;
import com.bfi.backend.client.dtos.BankAccountDto;
import com.bfi.backend.client.dtos.ClientDto;
import com.bfi.backend.client.dtos.PersonneMoraleDto;
import com.bfi.backend.client.dtos.PersonnePhysiqueDto;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.SignUpPersonneMoraleDto;
import com.bfi.backend.client.dtos.SignUpPersonnePhysiqueDto;
import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.entites.AdditionalInfoCorporation;
import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.entites.PersonneMorale;
import com.bfi.backend.client.entites.PersonnePhysique;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T09:29:29+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client signUpToClient(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        Client.ClientBuilder<?, ?> client = Client.builder();

        client.agency( signUpDtoToAgency( signUpDto ) );
        client.firstName( signUpDto.firstName() );
        client.lastName( signUpDto.lastName() );
        client.email( signUpDto.email() );
        client.gender( signUpDto.gender() );
        client.photo( signUpDto.photo() );
        client.phoneNumber( signUpDto.phoneNumber() );
        client.dateOfBirth( signUpDto.dateOfBirth() );
        client.login( signUpDto.login() );
        client.password( mapPassword( signUpDto.password() ) );
        client.address( toAddress( signUpDto.address() ) );

        return client.build();
    }

    @Override
    public ClientDto toClientDto(Client Client) {
        if ( Client == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder<?, ?> clientDto = ClientDto.builder();

        clientDto.bankAccounts( bankAccountListToBankAccountDtoList( Client.getBankAccountList() ) );
        clientDto.agencyId( clientAgencyIdAgency( Client ) );
        clientDto.id( Client.getId() );
        clientDto.gender( Client.getGender() );
        clientDto.firstName( Client.getFirstName() );
        clientDto.lastName( Client.getLastName() );
        clientDto.photo( Client.getPhoto() );
        clientDto.email( Client.getEmail() );
        clientDto.phoneNumber( Client.getPhoneNumber() );
        clientDto.dateOfBirth( Client.getDateOfBirth() );
        clientDto.login( Client.getLogin() );
        clientDto.address( toAddressDto( Client.getAddress() ) );

        return clientDto.build();
    }

    @Override
    public BankAccountDto toBankAccountDto(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountDto.BankAccountDtoBuilder bankAccountDto = BankAccountDto.builder();

        bankAccountDto.rib( bankAccount.getRib() );
        bankAccountDto.code( bankAccount.getCode() );

        return bankAccountDto.build();
    }

    @Override
    public BankAccount toBankAccount(BankAccountDto bankAccountDto) {
        if ( bankAccountDto == null ) {
            return null;
        }

        BankAccount.BankAccountBuilder bankAccount = BankAccount.builder();

        bankAccount.rib( bankAccountDto.getRib() );
        bankAccount.code( bankAccountDto.getCode() );

        return bankAccount.build();
    }

    @Override
    public AddressDto toAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto.AddressDtoBuilder addressDto = AddressDto.builder();

        addressDto.country( address.getCountry() );
        addressDto.city( address.getCity() );
        addressDto.neighbourhood( address.getNeighbourhood() );
        addressDto.zipCode( address.getZipCode() );

        return addressDto.build();
    }

    @Override
    public Address toAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.country( addressDto.getCountry() );
        address.city( addressDto.getCity() );
        address.neighbourhood( addressDto.getNeighbourhood() );
        address.zipCode( addressDto.getZipCode() );

        return address.build();
    }

    @Override
    public AdditionalInfoDto toAdditionalInfoDto(AdditionalInfo additionalInfo) {
        if ( additionalInfo == null ) {
            return null;
        }

        AdditionalInfoDto.AdditionalInfoDtoBuilder<?, ?> additionalInfoDto = AdditionalInfoDto.builder();

        additionalInfoDto.pieceType( additionalInfo.getPieceType() );
        additionalInfoDto.pieceNumber( additionalInfo.getPieceNumber() );
        additionalInfoDto.expirationDate( additionalInfo.getExpirationDate() );
        additionalInfoDto.piecePhoto( additionalInfo.getPiecePhoto() );
        additionalInfoDto.referralCode( additionalInfo.getReferralCode() );

        return additionalInfoDto.build();
    }

    @Override
    public AdditionalInfo toAdditionalInfo(AdditionalInfoDto additionalInfoDto) {
        if ( additionalInfoDto == null ) {
            return null;
        }

        AdditionalInfo.AdditionalInfoBuilder<?, ?> additionalInfo = AdditionalInfo.builder();

        additionalInfo.pieceType( additionalInfoDto.getPieceType() );
        additionalInfo.piecePhoto( additionalInfoDto.getPiecePhoto() );
        additionalInfo.referralCode( additionalInfoDto.getReferralCode() );
        additionalInfo.pieceNumber( additionalInfoDto.getPieceNumber() );
        additionalInfo.expirationDate( additionalInfoDto.getExpirationDate() );

        return additionalInfo.build();
    }

    @Override
    public PersonnePhysique signUpToPersonnePhysique(SignUpPersonnePhysiqueDto ClientDto) {
        if ( ClientDto == null ) {
            return null;
        }

        PersonnePhysique.PersonnePhysiqueBuilder<?, ?> personnePhysique = PersonnePhysique.builder();

        personnePhysique.agency( signUpPersonnePhysiqueDtoToAgency( ClientDto ) );
        personnePhysique.firstName( ClientDto.firstName() );
        personnePhysique.lastName( ClientDto.lastName() );
        personnePhysique.email( ClientDto.email() );
        personnePhysique.gender( ClientDto.gender() );
        personnePhysique.photo( ClientDto.photo() );
        personnePhysique.phoneNumber( ClientDto.phoneNumber() );
        personnePhysique.dateOfBirth( ClientDto.dateOfBirth() );
        personnePhysique.login( ClientDto.login() );
        personnePhysique.password( mapPassword( ClientDto.password() ) );
        personnePhysique.address( toAddress( ClientDto.address() ) );
        personnePhysique.additionalInfo( ClientDto.additionalInfo() );

        return personnePhysique.build();
    }

    @Override
    public PersonneMorale signUpToPersonneMorale(SignUpPersonneMoraleDto ClientDto) {
        if ( ClientDto == null ) {
            return null;
        }

        PersonneMorale.PersonneMoraleBuilder<?, ?> personneMorale = PersonneMorale.builder();

        personneMorale.agency( signUpPersonneMoraleDtoToAgency( ClientDto ) );
        personneMorale.firstName( ClientDto.firstName() );
        personneMorale.lastName( ClientDto.lastName() );
        personneMorale.email( ClientDto.email() );
        personneMorale.gender( ClientDto.gender() );
        personneMorale.photo( ClientDto.photo() );
        personneMorale.phoneNumber( ClientDto.phoneNumber() );
        personneMorale.dateOfBirth( ClientDto.dateOfBirth() );
        personneMorale.login( ClientDto.login() );
        personneMorale.password( mapPassword( ClientDto.password() ) );
        personneMorale.address( toAddress( ClientDto.address() ) );
        personneMorale.raisonSocial( ClientDto.raisonSocial() );
        personneMorale.formeJuridique( ClientDto.formeJuridique() );
        personneMorale.abreviation( ClientDto.abreviation() );
        personneMorale.categorie( ClientDto.categorie() );
        personneMorale.dateCreation( ClientDto.dateCreation() );
        personneMorale.codeRCCM( ClientDto.codeRCCM() );
        personneMorale.codeNIF( ClientDto.codeNIF() );
        personneMorale.secteurActivite( ClientDto.secteurActivite() );
        personneMorale.additionalInfo( additionalInfoMoralDtoToAdditionalInfoCorporation( ClientDto.additionalInfo() ) );

        return personneMorale.build();
    }

    @Override
    public PersonnePhysiqueDto toPersonnePhysiqueDto(PersonnePhysique Client) {
        if ( Client == null ) {
            return null;
        }

        PersonnePhysiqueDto.PersonnePhysiqueDtoBuilder<?, ?> personnePhysiqueDto = PersonnePhysiqueDto.builder();

        personnePhysiqueDto.agencyId( clientAgencyIdAgency1( Client ) );
        personnePhysiqueDto.id( Client.getId() );
        personnePhysiqueDto.login( Client.getLogin() );
        personnePhysiqueDto.address( toAddressDto( Client.getAddress() ) );
        personnePhysiqueDto.additionalInfo( toAdditionalInfoDto( Client.getAdditionalInfo() ) );
        personnePhysiqueDto.firstName( Client.getFirstName() );
        personnePhysiqueDto.lastName( Client.getLastName() );
        personnePhysiqueDto.gender( Client.getGender() );
        personnePhysiqueDto.dateOfBirth( Client.getDateOfBirth() );
        personnePhysiqueDto.photo( Client.getPhoto() );
        personnePhysiqueDto.email( Client.getEmail() );
        personnePhysiqueDto.phoneNumber( Client.getPhoneNumber() );

        return personnePhysiqueDto.build();
    }

    @Override
    public PersonneMoraleDto toPersonneMoraleDto(PersonneMorale Client) {
        if ( Client == null ) {
            return null;
        }

        PersonneMoraleDto.PersonneMoraleDtoBuilder<?, ?> personneMoraleDto = PersonneMoraleDto.builder();

        personneMoraleDto.agencyId( clientAgencyIdAgency2( Client ) );
        personneMoraleDto.id( Client.getId() );
        personneMoraleDto.login( Client.getLogin() );
        personneMoraleDto.address( toAddressDto( Client.getAddress() ) );
        personneMoraleDto.additionalInfo( toAdditionalInfoDto( Client.getAdditionalInfo() ) );
        personneMoraleDto.firstName( Client.getFirstName() );
        personneMoraleDto.lastName( Client.getLastName() );
        personneMoraleDto.gender( Client.getGender() );
        personneMoraleDto.dateOfBirth( Client.getDateOfBirth() );
        personneMoraleDto.photo( Client.getPhoto() );
        personneMoraleDto.email( Client.getEmail() );
        personneMoraleDto.phoneNumber( Client.getPhoneNumber() );
        personneMoraleDto.raisonSocial( Client.getRaisonSocial() );
        personneMoraleDto.formeJuridique( Client.getFormeJuridique() );
        personneMoraleDto.abreviation( Client.getAbreviation() );
        personneMoraleDto.categorie( Client.getCategorie() );
        personneMoraleDto.dateCreation( Client.getDateCreation() );
        personneMoraleDto.codeRCCM( Client.getCodeRCCM() );
        personneMoraleDto.codeNIF( Client.getCodeNIF() );
        personneMoraleDto.secteurActivite( Client.getSecteurActivite() );

        return personneMoraleDto.build();
    }

    protected Agency signUpDtoToAgency(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        Agency.AgencyBuilder agency = Agency.builder();

        agency.idAgency( signUpDto.agencyId() );

        return agency.build();
    }

    protected List<BankAccountDto> bankAccountListToBankAccountDtoList(List<BankAccount> list) {
        if ( list == null ) {
            return null;
        }

        List<BankAccountDto> list1 = new ArrayList<BankAccountDto>( list.size() );
        for ( BankAccount bankAccount : list ) {
            list1.add( toBankAccountDto( bankAccount ) );
        }

        return list1;
    }

    private Long clientAgencyIdAgency(Client client) {
        if ( client == null ) {
            return null;
        }
        Agency agency = client.getAgency();
        if ( agency == null ) {
            return null;
        }
        Long idAgency = agency.getIdAgency();
        if ( idAgency == null ) {
            return null;
        }
        return idAgency;
    }

    protected Agency signUpPersonnePhysiqueDtoToAgency(SignUpPersonnePhysiqueDto signUpPersonnePhysiqueDto) {
        if ( signUpPersonnePhysiqueDto == null ) {
            return null;
        }

        Agency.AgencyBuilder agency = Agency.builder();

        agency.idAgency( signUpPersonnePhysiqueDto.agencyId() );

        return agency.build();
    }

    protected Agency signUpPersonneMoraleDtoToAgency(SignUpPersonneMoraleDto signUpPersonneMoraleDto) {
        if ( signUpPersonneMoraleDto == null ) {
            return null;
        }

        Agency.AgencyBuilder agency = Agency.builder();

        agency.idAgency( signUpPersonneMoraleDto.agencyId() );

        return agency.build();
    }

    protected AdditionalInfoCorporation additionalInfoMoralDtoToAdditionalInfoCorporation(AdditionalInfoMoralDto additionalInfoMoralDto) {
        if ( additionalInfoMoralDto == null ) {
            return null;
        }

        AdditionalInfoCorporation.AdditionalInfoCorporationBuilder<?, ?> additionalInfoCorporation = AdditionalInfoCorporation.builder();

        additionalInfoCorporation.pieceType( additionalInfoMoralDto.getPieceType() );
        additionalInfoCorporation.piecePhoto( additionalInfoMoralDto.getPiecePhoto() );
        additionalInfoCorporation.referralCode( additionalInfoMoralDto.getReferralCode() );
        additionalInfoCorporation.pieceNumber( additionalInfoMoralDto.getPieceNumber() );
        additionalInfoCorporation.expirationDate( additionalInfoMoralDto.getExpirationDate() );
        additionalInfoCorporation.companySize( additionalInfoMoralDto.getCompanySize() );
        additionalInfoCorporation.fieldActivity( additionalInfoMoralDto.getFieldActivity() );
        additionalInfoCorporation.natureSector( additionalInfoMoralDto.getNatureSector() );

        return additionalInfoCorporation.build();
    }

    private Long clientAgencyIdAgency1(PersonnePhysique personnePhysique) {
        if ( personnePhysique == null ) {
            return null;
        }
        Agency agency = personnePhysique.getAgency();
        if ( agency == null ) {
            return null;
        }
        Long idAgency = agency.getIdAgency();
        if ( idAgency == null ) {
            return null;
        }
        return idAgency;
    }

    private Long clientAgencyIdAgency2(PersonneMorale personneMorale) {
        if ( personneMorale == null ) {
            return null;
        }
        Agency agency = personneMorale.getAgency();
        if ( agency == null ) {
            return null;
        }
        Long idAgency = agency.getIdAgency();
        if ( idAgency == null ) {
            return null;
        }
        return idAgency;
    }
}
