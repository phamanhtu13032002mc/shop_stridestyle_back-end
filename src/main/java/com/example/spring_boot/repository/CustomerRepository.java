package com.example.spring_boot.repository;

import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.payload.request.CustomerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    @Query(value = "SELECT * FROM customer WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    Page<CustomerEntity> findAllCustomer(CustomerRequest customerRequest, Pageable pageable);
}