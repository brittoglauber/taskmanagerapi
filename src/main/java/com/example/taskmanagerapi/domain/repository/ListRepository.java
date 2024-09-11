package com.example.taskmanagerapi.domain.repository;

import com.example.taskmanagerapi.domain.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListRepository extends JpaRepository<ListEntity, Long> {
}
