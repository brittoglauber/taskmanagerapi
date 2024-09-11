package com.example.taskmanagerapi.service;


import com.example.taskmanagerapi.domain.entity.ListEntity;
import com.example.taskmanagerapi.domain.repository.ListRepository;
import com.example.taskmanagerapi.domain.service.ListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ListServiceTest {
    @InjectMocks
    private ListService listService;

    @Mock
    private ListRepository listRepository;

    private ListEntity listEntity;

    @BeforeEach
    void setUp() {
        listEntity = new ListEntity();
        listEntity.setId(1L);
        listEntity.setName("Test");
    }

    @Test
    @DisplayName("Should return a list by ID")
    void getListByIdSuccess() {
        when(listRepository.findById(any(Long.class))).thenReturn(Optional.of(listEntity));

        ListEntity foundList = listService.getListById(1L);

        assertAll(
                "Get List by ID",
                () -> assertNotNull(foundList),
                () -> assertEquals("List Test", foundList.getName())
        );
    }

    @Test
    @DisplayName("Should create a new list")
    void createListSuccess() {
        when(listRepository.save(any(ListEntity.class))).thenReturn(listEntity);

        ListEntity createdList = listService.createList(listEntity);

        assertAll(
                "Create list",
                () -> assertNotNull(createdList),
                () -> assertEquals(listEntity.getName(), createdList.getName())
        );
    }

    @Test
    @DisplayName("Should update an existing list")
    void updateListSuccess() {
        when(listRepository.findById(any(Long.class))).thenReturn(Optional.of(listEntity));
        when(listRepository.save(any(ListEntity.class))).thenReturn(listEntity);

        listEntity.setName("Updated List");
        ListEntity updatedList = listService.updateList(1L, listEntity);

        assertAll(
                "Update list",
                () -> assertNotNull(updatedList),
                () -> assertEquals("Updated List", updatedList.getName())
        );
    }

    @Test
    @DisplayName("Should delete a list by ID")
    void deleteListSuccess() {
        when(listRepository.findById(any(Long.class))).thenReturn(Optional.of(listEntity));

        assertDoesNotThrow(() -> listService.deleteList(1L));
    }

    @Test
    @DisplayName("Should return a list of all lists")
    void getAllListsSuccess() {
        List<ListEntity> lists = Arrays.asList(listEntity, listEntity);

        when(listRepository.findAll()).thenReturn(lists);

        List<ListEntity> foundLists = listService.getAllLists();

        assertAll(
                "Get all lists",
                () -> assertNotNull(foundLists),
                () -> assertEquals(2, foundLists.size()),
                () -> assertEquals("Test List", foundLists.get(0).getName()),
                () -> assertEquals("Another List", foundLists.get(1).getName())
        );
    }

    @Test
    @DisplayName("Should return an empty list when no lists are found")
    void getAllListsEmpty() {
        when(listRepository.findAll()).thenReturn(Arrays.asList());

        List<ListEntity> foundLists = listService.getAllLists();

        assertAll(
                "Get all lists empty",
                () -> assertNotNull(foundLists),
                () -> assertTrue(foundLists.isEmpty())
        );
    }
}
