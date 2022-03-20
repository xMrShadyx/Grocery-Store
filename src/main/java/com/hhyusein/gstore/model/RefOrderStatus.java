package com.hhyusein.gstore.model;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "ref_order_status")
public class RefOrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_order_id")
    private Long refOrderId;

    @Column(name = "order_status_code")
    private String orderStatusCode;

    // eg Collected by Customer
    // eg Delivered.
    @Column(name = "order_status_description")
    private String orderStatusDescription;
}
