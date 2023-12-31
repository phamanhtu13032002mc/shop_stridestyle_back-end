package com.example.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "image")
public class ImageEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;
    @Column(name = "isDelete")
    private Boolean isDelete = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product")
    private UserEntity account;

    @JsonIgnore
    @OneToMany(mappedBy = "image")
    List<ProductEntity> productEntities;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "idproduct")
//    private Product product;
}
