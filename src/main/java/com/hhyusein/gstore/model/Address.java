package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "line_1", nullable = false)
    private String line1;

    @Column(name = "line_2", nullable = false)
    private String line2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip_postcode", nullable = false)
    private String zipPostCode;

    @Column(name = "state_province_country", nullable = false)
    private String stateProvinceCountry;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "other_address_details", nullable = false)
    private String otherAddressDetails;
}
