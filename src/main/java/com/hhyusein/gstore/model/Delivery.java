package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long deliveryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "refDeliveryId")
    private RefDeliveryStatus deliveryStatusCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId")
    private Employee deliveredByEmployeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Order orderId;

    @Temporal(TemporalType.DATE)
    private Date deliveryDateTime;

    private String otherDeliveryDetails;
}
