package com.example.taskmanagerapi.domain.repository;

import com.example.taskmanagerapi.domain.entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {

}