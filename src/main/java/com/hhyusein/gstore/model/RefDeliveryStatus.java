package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "ref_delivery_status")
public class RefDeliveryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_delivery_id")
    private Long refDeliveryId;

    @Column(name = "delivery_status_code")
    private String deliveryStatusCode;

    // eg Planned
    // eg Delivered.
    @Column(name = "delivery_status_description")
    private String deliveryStatusDescription;
}
