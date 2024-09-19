package com.example.taskmanagerapi.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ItemDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private Boolean isPriority;
}
