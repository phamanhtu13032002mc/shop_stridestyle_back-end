package com.example.spring_boot.repository;

import com.example.spring_boot.entity.VoucherBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoucherBillRespository extends JpaRepository<VoucherBillEntity,Long> {
    @Query(value = "SELECT * FROM voucherbill WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<VoucherBillEntity> findAllByIsDeleteFalse();
}
