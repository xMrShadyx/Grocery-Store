package com.hhyusein.gstore.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@ToString
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address employeeAddressId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_phone", nullable = false)
    private String employeePhone;

    @Column(name = "other_employee_details", nullable = false)
    private String otherEmployeeDetails;



}
