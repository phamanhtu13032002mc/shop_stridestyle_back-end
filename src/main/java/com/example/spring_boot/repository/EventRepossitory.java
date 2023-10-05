package com.example.spring_boot.repository;

import com.example.spring_boot.entity.Category;
import com.example.spring_boot.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepossitory  extends JpaRepository<Event,Long>{
    @Query(value = "SELECT * FROM event WHERE is_delete = 0 ORDER BY id DESC",nativeQuery = true)
    List<Event> findAllByIsDeleteFase();
}
