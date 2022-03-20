package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "refOrderId")
    private RefOrderStatus orderStatusCode;

    @Temporal(TemporalType.DATE)
    private Date orderDayDate;

    @Column(name = "paid_for_yn", nullable = false)
    private String paidForYn;

    @Column(name = "other_details")
    private String otherDetails;
}
