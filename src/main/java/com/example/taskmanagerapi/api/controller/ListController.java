package com.example.taskmanagerapi.api.controller;

import com.example.taskmanagerapi.domain.entity.ListEntity;
import com.example.taskmanagerapi.domain.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lists")
public class ListController {

    @Autowired
    private ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping
    public ResponseEntity<ListEntity> createList(@RequestBody ListEntity listEntity) {
        return ResponseEntity.ok(listService.createList(listEntity));
    }

    @GetMapping
    public ResponseEntity<List<ListEntity>> getAllLists() {
        return ResponseEntity.ok(listService.getAllLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListEntity> getListById(@PathVariable Long id) {
        return ResponseEntity.ok(listService.getListById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListEntity> updateList(@PathVariable Long id, @RequestBody ListEntity listEntity) {
        return ResponseEntity.ok(listService.updateList(id, listEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        listService.deleteList(id);
        return ResponseEntity.noContent().build();
    }
}
