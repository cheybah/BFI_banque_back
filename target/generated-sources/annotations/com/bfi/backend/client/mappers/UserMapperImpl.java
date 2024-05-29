package com.bfi.backend.client.mappers;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.client.dtos.AdditionalInfoDto;
import com.bfi.backend.client.dtos.AddressDto;
import com.bfi.backend.client.dtos.BankAccountDto;
import com.bfi.backend.client.dtos.PersonneMoraleDto;
import com.bfi.backend.client.dtos.PersonnePhysiqueDto;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.SignUpPersonneMoraleDto;
import com.bfi.backend.client.dtos.SignUpPersonnePhysiqueDto;
import com.bfi.backend.client.dtos.UserDto;
import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.PersonneMorale;
import com.bfi.backend.client.entites.PersonnePhysique;
import com.bfi.backend.client.entites.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T09:43:28+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.agency( signUpDtoToAgency( signUpDto ) );
        user.gender( signUpDto.gender() );
        user.firstName( signUpDto.firstName() );
        user.lastName( signUpDto.lastName() );
        user.photo( signUpDto.photo() );
        user.email( signUpDto.email() );
        user.phoneNumber( signUpDto.phoneNumber() );
        user.dateOfBirth( signUpDto.dateOfBirth() );
        user.login( signUpDto.login() );
        user.password( mapPassword( signUpDto.password() ) );
        user.address( toAddress( signUpDto.address() ) );
        user.additionalInfo( toAdditionalInfo( signUpDto.additionalInfo() ) );

        return user.build();
    }

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder<?, ?> userDto = UserDto.builder();

        userDto.bankAccounts( bankAccountListToBankAccountDtoList( user.getBankAccountList() ) );
        userDto.agencyId( userAgencyIdAgency( user ) );
        userDto.id( user.getId() );
        userDto.gender( user.getGender() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.photo( user.getPhoto() );
        userDto.email( user.getEmail() );
        userDto.phoneNumber( user.getPhoneNumber() );
        userDto.dateOfBirth( user.getDateOfBirth() );
        userDto.login( user.getLogin() );
        userDto.address( toAddressDto( user.getAddress() ) );
        userDto.additionalInfo( toAdditionalInfoDto( user.getAdditionalInfo() ) );

        return userDto.build();
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

        AdditionalInfoDto.AdditionalInfoDtoBuilder additionalInfoDto = AdditionalInfoDto.builder();

        additionalInfoDto.typeIndividual( additionalInfo.getTypeIndividual() );
        additionalInfoDto.profession( additionalInfo.getProfession() );
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

        AdditionalInfo.AdditionalInfoBuilder additionalInfo = AdditionalInfo.builder();

        additionalInfo.typeIndividual( additionalInfoDto.getTypeIndividual() );
        additionalInfo.profession( additionalInfoDto.getProfession() );
        additionalInfo.pieceType( additionalInfoDto.getPieceType() );
        additionalInfo.pieceNumber( additionalInfoDto.getPieceNumber() );
        additionalInfo.expirationDate( additionalInfoDto.getExpirationDate() );
        additionalInfo.piecePhoto( additionalInfoDto.getPiecePhoto() );
        additionalInfo.referralCode( additionalInfoDto.getReferralCode() );

        return additionalInfo.build();
    }

    @Override
    public PersonnePhysique signUpToPersonnePhysique(SignUpPersonnePhysiqueDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        PersonnePhysique.PersonnePhysiqueBuilder<?, ?> personnePhysique = PersonnePhysique.builder();

        personnePhysique.agency( signUpPersonnePhysiqueDtoToAgency( userDto ) );
        personnePhysique.gender( userDto.gender() );
        personnePhysique.firstName( userDto.firstName() );
        personnePhysique.lastName( userDto.lastName() );
        personnePhysique.photo( userDto.photo() );
        personnePhysique.email( userDto.email() );
        personnePhysique.phoneNumber( userDto.phoneNumber() );
        personnePhysique.dateOfBirth( userDto.dateOfBirth() );
        personnePhysique.login( userDto.login() );
        personnePhysique.password( mapPassword( userDto.password() ) );
        personnePhysique.address( toAddress( userDto.address() ) );
        personnePhysique.additionalInfo( toAdditionalInfo( userDto.additionalInfo() ) );

        return personnePhysique.build();
    }

    @Override
    public PersonneMorale signUpToPersonneMorale(SignUpPersonneMoraleDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        PersonneMorale.PersonneMoraleBuilder<?, ?> personneMorale = PersonneMorale.builder();

        personneMorale.agency( signUpPersonneMoraleDtoToAgency( userDto ) );
        personneMorale.gender( userDto.gender() );
        personneMorale.firstName( userDto.firstName() );
        personneMorale.lastName( userDto.lastName() );
        personneMorale.photo( userDto.photo() );
        personneMorale.email( userDto.email() );
        personneMorale.phoneNumber( userDto.phoneNumber() );
        personneMorale.dateOfBirth( userDto.dateOfBirth() );
        personneMorale.login( userDto.login() );
        personneMorale.password( mapPassword( userDto.password() ) );
        personneMorale.address( toAddress( userDto.address() ) );
        personneMorale.additionalInfo( toAdditionalInfo( userDto.additionalInfo() ) );
        personneMorale.raisonSocial( userDto.raisonSocial() );
        personneMorale.formeJuridique( userDto.formeJuridique() );
        personneMorale.abreviation( userDto.abreviation() );
        personneMorale.categorie( userDto.categorie() );
        personneMorale.dateCreation( userDto.dateCreation() );
        personneMorale.codeRCCM( userDto.codeRCCM() );
        personneMorale.codeNIF( userDto.codeNIF() );
        personneMorale.secteurActivite( userDto.secteurActivite() );

        return personneMorale.build();
    }

    @Override
    public PersonnePhysiqueDto toPersonnePhysiqueDto(PersonnePhysique user) {
        if ( user == null ) {
            return null;
        }

        PersonnePhysiqueDto.PersonnePhysiqueDtoBuilder<?, ?> personnePhysiqueDto = PersonnePhysiqueDto.builder();

        personnePhysiqueDto.agencyId( userAgencyIdAgency1( user ) );
        personnePhysiqueDto.id( user.getId() );
        personnePhysiqueDto.login( user.getLogin() );
        personnePhysiqueDto.address( toAddressDto( user.getAddress() ) );
        personnePhysiqueDto.additionalInfo( toAdditionalInfoDto( user.getAdditionalInfo() ) );
        personnePhysiqueDto.firstName( user.getFirstName() );
        personnePhysiqueDto.lastName( user.getLastName() );
        personnePhysiqueDto.gender( user.getGender() );
        personnePhysiqueDto.dateOfBirth( user.getDateOfBirth() );
        personnePhysiqueDto.photo( user.getPhoto() );
        personnePhysiqueDto.email( user.getEmail() );
        personnePhysiqueDto.phoneNumber( user.getPhoneNumber() );

        return personnePhysiqueDto.build();
    }

    @Override
    public PersonneMoraleDto toPersonneMoraleDto(PersonneMorale user) {
        if ( user == null ) {
            return null;
        }

        PersonneMoraleDto.PersonneMoraleDtoBuilder<?, ?> personneMoraleDto = PersonneMoraleDto.builder();

        personneMoraleDto.agencyId( userAgencyIdAgency2( user ) );
        personneMoraleDto.id( user.getId() );
        personneMoraleDto.login( user.getLogin() );
        personneMoraleDto.address( toAddressDto( user.getAddress() ) );
        personneMoraleDto.additionalInfo( toAdditionalInfoDto( user.getAdditionalInfo() ) );
        personneMoraleDto.firstName( user.getFirstName() );
        personneMoraleDto.lastName( user.getLastName() );
        personneMoraleDto.gender( user.getGender() );
        personneMoraleDto.dateOfBirth( user.getDateOfBirth() );
        personneMoraleDto.photo( user.getPhoto() );
        personneMoraleDto.email( user.getEmail() );
        personneMoraleDto.phoneNumber( user.getPhoneNumber() );
        personneMoraleDto.raisonSocial( user.getRaisonSocial() );
        personneMoraleDto.formeJuridique( user.getFormeJuridique() );
        personneMoraleDto.abreviation( user.getAbreviation() );
        personneMoraleDto.categorie( user.getCategorie() );
        personneMoraleDto.dateCreation( user.getDateCreation() );
        personneMoraleDto.codeRCCM( user.getCodeRCCM() );
        personneMoraleDto.codeNIF( user.getCodeNIF() );
        personneMoraleDto.secteurActivite( user.getSecteurActivite() );

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

    private Long userAgencyIdAgency(User user) {
        if ( user == null ) {
            return null;
        }
        Agency agency = user.getAgency();
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

    private Long userAgencyIdAgency1(PersonnePhysique personnePhysique) {
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

    private Long userAgencyIdAgency2(PersonneMorale personneMorale) {
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
