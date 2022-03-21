package com.hhyusein.gstore.service.impl;

import com.hhyusein.gstore.Repository.AddressRepository;
import com.hhyusein.gstore.exception.DuplicateRecordException;
import com.hhyusein.gstore.exception.EmptyRecordException;
import com.hhyusein.gstore.exception.ResourceNotFoundException;
import com.hhyusein.gstore.model.Address;
import com.hhyusein.gstore.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        List<Address> getAllAddresses = addressRepository.findAll();

        if (getAllAddresses.isEmpty()) {
            throw new EmptyRecordException("There is no record's in Database.");
        }

        return getAllAddresses;

    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Address with ID: %d not found in the Database", id)));
    }

    @Override
    public Address findByCity(String city) {
        return addressRepository.findByCity(city)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, City %s not found in the Database", city)));
    }

    @Override
    public Address findByCountry(String country) {
        return addressRepository.findByCountry(country)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Country %s not found in the Database", country)));
    }

    @Override
    public Address findByStateProvinceCountry(String stateProvinceCountry) {
        return addressRepository.findByStateProvinceCountry(stateProvinceCountry)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Province/Country %s not found in the Database", stateProvinceCountry)));
    }

    @Override
    public Address findByZipPostCode(String zipPostCode) {
        return addressRepository.findByZipPostCode(zipPostCode)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Zipcode %s not found in the Database", zipPostCode)));
    }

    @Override
    public Address saveAddress(Address address) {

        Address lookForLine1 = addressRepository.findByLine1(address.getLine1());
        Address lookForLine2 = addressRepository.findByLine2(address.getLine2());

        if (lookForLine1 != null || lookForLine2 != null) {
            throw new DuplicateRecordException(String.format("This Address already exists at our DB with ID %d", address.getAddressId()));
        }

        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Long id) {
        Address foundAddress = findById(id);
        Address addressToUpdate = Address.builder()
                .addressId(foundAddress.getAddressId())
                .line1(address.getLine1())
                .line2(address.getLine2())
                .city(address.getCity())
                .zipPostCode(address.getZipPostCode())
                .stateProvinceCountry(address.getStateProvinceCountry())
                .country(address.getCountry())
                .otherAddressDetails(address.getOtherAddressDetails())
                .build();
        return saveAddress(addressToUpdate);
    }

    @Override
    public void deleteAddress(Long id) {
        Address checkIfIdIsInDatabase = addressRepository.findById(id)
                .orElseThrow(() -> new EmptyRecordException(String.format("Can't complete delete operation ID %d does not exist.", id)));
        addressRepository.deleteById(checkIfIdIsInDatabase.getAddressId());

    }
}
