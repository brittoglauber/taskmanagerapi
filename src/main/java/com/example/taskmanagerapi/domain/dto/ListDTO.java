package com.example.taskmanagerapi.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListDTO {
    private Long id;
    private String name;
    private List<ItemDTO> items;
}
