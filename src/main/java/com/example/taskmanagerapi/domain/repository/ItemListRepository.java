package com.example.taskmanagerapi.domain.repository;

import com.example.taskmanagerapi.domain.entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
    @Query("SELECT il FROM ItemList il WHERE il.item.id = :itemId AND il.list.id = :listId")
    Optional<ItemList> findByItemAndList(Long itemId, Long listId);
}