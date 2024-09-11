package com.example.taskmanagerapi.service;


import com.example.taskmanagerapi.domain.dto.ItemRequestSaveDTO;
import com.example.taskmanagerapi.domain.entity.ItemEntity;
import com.example.taskmanagerapi.domain.repository.ItemRepository;
import com.example.taskmanagerapi.domain.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    private ItemEntity item;

    private ItemRequestSaveDTO requestSaveDTO;

    @BeforeEach
    void setUp() {
        item = new ItemEntity();
        item.setId(1L);
        item.setTitle("Item Test");
        item.setDescription("Item description");
    }

    @Test
    @DisplayName("Should return an item by ID")
    void getItemByIdSuccess() {
        when(itemRepository.findById(any(Long.class))).thenReturn(Optional.of(item));

        ItemEntity foundItem = itemService.getItemById(1L);

        assertAll(
                "Get item by ID",
                () -> assertNotNull(foundItem),
                () -> assertEquals("Item Test", foundItem.getTitle()),
                () -> assertEquals("Item description", foundItem.getDescription())
        );
    }

    @Test
    @DisplayName("Should create a new item")
    void createItemSuccess() {
        when(itemRepository.save(any(ItemEntity.class))).thenReturn(item);

        ItemEntity createdItem = itemService.createItem(requestSaveDTO);

        assertAll(
                "Create item",
                () -> assertNotNull(createdItem),
                () -> assertEquals(item.getTitle(), createdItem.getTitle()),
                () -> assertEquals(item.getDescription(), createdItem.getDescription())
        );
    }

    @Test
    @DisplayName("Should update an existing item")
    void updateItemSuccess() {
        when(itemRepository.findById(any(Long.class))).thenReturn(Optional.of(item));
        when(itemRepository.save(any(ItemEntity.class))).thenReturn(item);

        ItemEntity updatedItem = itemService.updateItem(1L, item);

        assertAll(
                "Update item",
                () -> assertNotNull(updatedItem),
                () -> assertEquals(item.getTitle(), updatedItem.getDescription())
        );
    }


    @Test
    @DisplayName("Should delete an item by its ID")
    void deleteItemSuccess() {
        when(itemRepository.findById(any(Long.class))).thenReturn(Optional.of(item));

        assertDoesNotThrow(() -> itemService.deleteItem(1L));
    }

}
