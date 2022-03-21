package com.hhyusein.gstore.Repository;

import com.hhyusein.gstore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findById(Long id);
    Optional<Address> findByCity(String city);
    Optional<Address> findByCountry(String country);
    Optional<Address> findByStateProvinceCountry(String stateProvinceCountry);
    Optional<Address> findByZipPostCode(String zipPostCode);

    Address findByLine1(String line1);
    Address findByLine2(String line2);
}
