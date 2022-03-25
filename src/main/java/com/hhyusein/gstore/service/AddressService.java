package com.hhyusein.gstore.service;

import com.hhyusein.gstore.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();

    Address findById(Long id);
    Address findByCity(String city);
    Address findByCountry(String country);
    Address findByStateProvinceCountry(String stateProvinceCountry);
    Address findByZipPostCode(String zipPostCode);

    Address saveAddress(Address address);
    Address updateAddress(Address address, Long id);
    void deleteAddressById(Long id);
}
