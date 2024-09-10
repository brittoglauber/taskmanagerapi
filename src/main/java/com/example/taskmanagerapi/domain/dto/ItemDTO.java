package com.example.taskmanagerapi.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private Boolean isPriority;
}
