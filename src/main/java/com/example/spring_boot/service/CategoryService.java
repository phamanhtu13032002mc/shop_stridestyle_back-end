package com.example.spring_boot.service;

import com.example.spring_boot.entity.CategoryEntity;
import com.example.spring_boot.payload.request.CategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> findAllDeleteIsFalse();

    List<CategoryEntity> findAll(CategoryRequest categoryRequest);

    CategoryEntity save(CategoryEntity categoryEntity);

    void delete(Long id);

    Optional<CategoryEntity> findByID(Long id);

}