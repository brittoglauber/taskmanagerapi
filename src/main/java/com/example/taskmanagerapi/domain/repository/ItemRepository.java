package com.example.taskmanagerapi.domain.repository;

import com.example.taskmanagerapi.domain.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByListId(Long listId);
}
