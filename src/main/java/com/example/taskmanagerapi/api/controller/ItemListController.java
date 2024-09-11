package com.example.taskmanagerapi.api.controller;

import com.example.taskmanagerapi.api.exception.ApiException;
import com.example.taskmanagerapi.domain.entity.ItemList;
import com.example.taskmanagerapi.domain.enums.ErrosEnum;
import com.example.taskmanagerapi.domain.service.ItemListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<ItemList>> getAllItemList() {
        return ResponseEntity.ok(itemListService.getAll());
    }
}
