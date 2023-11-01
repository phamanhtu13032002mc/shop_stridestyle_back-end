package com.example.spring_boot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "voucherbill")
public class VoucherBillEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_bill")
    private BillEntity billEntity;


    @JsonIgnore
    @OneToOne(mappedBy = "eventEntity")
    private VoucherEntity voucherEntities;

}
