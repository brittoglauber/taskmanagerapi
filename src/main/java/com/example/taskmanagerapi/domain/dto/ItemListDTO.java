package com.example.taskmanagerapi.domain.dto;

import com.example.taskmanagerapi.domain.entity.ItemEntity;
import com.example.taskmanagerapi.domain.entity.ListEntity;
import lombok.Data;

import java.util.List;

@Data
public class ItemListDTO {
    private List<ItemEntity> items;
    private List<ListEntity> lists;
}
