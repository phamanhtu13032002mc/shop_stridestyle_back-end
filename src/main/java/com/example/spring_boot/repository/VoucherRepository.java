package com.example.spring_boot.repository;

import com.example.spring_boot.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoucherRepository extends JpaRepository<VoucherEntity,Long> {

    @Query(value = "SELECT * FROM voucher WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<VoucherEntity> findAllByIsDeleteFalse();
}
