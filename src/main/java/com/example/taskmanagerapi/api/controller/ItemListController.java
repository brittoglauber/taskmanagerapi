package com.example.taskmanagerapi.api.controller;

import com.example.taskmanagerapi.domain.dto.ListWithItemsDTO;
import com.example.taskmanagerapi.domain.entity.ItemList;
import com.example.taskmanagerapi.domain.service.ItemListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-list")
public class ItemListController {
    private final ItemListService itemListService;

    public ItemListController(ItemListService itemListService) {
        this.itemListService = itemListService;
    }

    @PostMapping("/associate")
    public ResponseEntity<ItemList> associateItemToList(
            @RequestParam Long itemId,
            @RequestParam Long listId
    ) {

        ItemList itemListEntity = itemListService.associateItemToList(itemId, listId);
        return ResponseEntity.ok(itemListEntity);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ListWithItemsDTO>> getAllItemList() {
        return ResponseEntity.ok(itemListService.getAll());
    }
}
