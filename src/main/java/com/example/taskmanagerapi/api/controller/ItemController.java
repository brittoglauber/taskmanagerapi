package com.example.taskmanagerapi.api.controller;

import com.example.taskmanagerapi.domain.dto.ItemRequestSaveDTO;
import com.example.taskmanagerapi.domain.entity.ItemEntity;
import com.example.taskmanagerapi.domain.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemEntity> createItem (@Valid @RequestBody ItemRequestSaveDTO itemRequestSaveDTO) {
        ItemEntity createdItem = itemService.createItem(itemRequestSaveDTO);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemEntity> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemEntity> updateItem(@PathVariable Long id, @RequestBody ItemEntity itemEntity) {
        return ResponseEntity.ok(itemService.updateItem(id, itemEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
