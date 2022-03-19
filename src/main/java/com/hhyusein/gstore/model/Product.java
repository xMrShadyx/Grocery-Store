package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productRefId")
    private RefProductType productType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierId")
    private Supplier supplierId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "other_details", nullable = false)
    private String otherDetails;
}
