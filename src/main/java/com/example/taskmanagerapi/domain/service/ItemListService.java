package com.example.taskmanagerapi.domain.service;

import com.example.taskmanagerapi.domain.entity.ItemEntity;
import com.example.taskmanagerapi.domain.entity.ItemList;
import com.example.taskmanagerapi.domain.entity.ListEntity;
import com.example.taskmanagerapi.domain.repository.ItemListRepository;
import com.example.taskmanagerapi.domain.repository.ItemRepository;
import com.example.taskmanagerapi.domain.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemListService {
    private final ItemRepository itemRepository;
    private final ListRepository listRepository;
    private final ItemListRepository itemListRepository;

    public ItemListService(ItemRepository itemRepository, ListRepository listRepository, ItemListRepository itemListRepository) {
        this.itemRepository = itemRepository;
        this.listRepository = listRepository;
        this.itemListRepository = itemListRepository;
    }

    public List<ItemList> getAll() {
        return itemListRepository.findAll();
    }

    public ItemList associateItemToList(Long itemId, Long listId) {
        ItemEntity item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("List not found"));

        ItemList itemListEntity = new ItemList(item, list);
        return itemListRepository.save(itemListEntity);
    }

}
