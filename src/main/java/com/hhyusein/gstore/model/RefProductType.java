package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "ref_product_types")
public class RefProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_ref_id")
    private Long productRefId;

    // Reference like VEG, FRU
    @Column(name = "product_type_ref", nullable = false)
    private String productTypeReference;

    // Description for the reference eg VEG = Vegetables.
    @Column(name = "product_type_description", nullable = false)
    private String productTypeDescription;
}
