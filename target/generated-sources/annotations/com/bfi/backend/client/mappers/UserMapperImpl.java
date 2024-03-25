package com.bfi.backend.client.mappers;

import com.bfi.backend.client.dtos.AdditionalInfoDto;
import com.bfi.backend.client.dtos.AddressDto;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.UserDto;
import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.entites.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-22T12:36:37+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

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
    public User signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.gender( signUpDto.gender() );
        user.firstName( signUpDto.firstName() );
        user.lastName( signUpDto.lastName() );
        user.photo( signUpDto.photo() );
        user.email( signUpDto.email() );
        user.phoneNumber( signUpDto.phoneNumber() );
        user.dateOfBirth( signUpDto.dateOfBirth() );
        user.login( signUpDto.login() );
        user.address( toAddress( signUpDto.address() ) );
        user.additionalInfo( toAdditionalInfo( signUpDto.additionalInfo() ) );

        return user.build();
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
}
