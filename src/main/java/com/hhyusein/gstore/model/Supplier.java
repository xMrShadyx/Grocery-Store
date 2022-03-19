package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;

    @OneToOne
    private Address supplierAddressId;

    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @Column(name = "supplier_phone", nullable = false)
    private String supplierPhone;

    @Column(name = "supplier_email", nullable = false)
    private String supplierEmail;

    @Column(name = "other_details", nullable = false)
    private String otherDetails;
}
