package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orderdetail")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OderDetailEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;//giá gốc
    private Double intoMoney;//thành tiền
    private Double downPrice;//giá giảm
    private Long quantity_oder;//số lượng mua

    @Column(name = "isDelete")
    @Builder.Default
    private Boolean isDelete = false;


    @OneToMany(mappedBy = "orderEntity")
    private List<ProductEntity> productEntities;


    @ManyToOne
    @JoinColumn(name = "id_bill", updatable = false, insertable = false)
    private BillEntity billEntity;

    @Column(name = "id_bill")
    private String idBill;

}
