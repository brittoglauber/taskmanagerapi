package com.example.taskmanagerapi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListWithItemsDTO {
    private Long listId;
    private String listName;
    private List<ItemDTO> items;
}
