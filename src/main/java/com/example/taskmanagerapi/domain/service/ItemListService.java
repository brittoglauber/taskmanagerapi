package com.example.taskmanagerapi.domain.service;

import com.example.taskmanagerapi.api.exception.ItemAlreadyInListException;
import com.example.taskmanagerapi.domain.dto.ItemDTO;
import com.example.taskmanagerapi.domain.dto.ListWithItemsDTO;
import com.example.taskmanagerapi.domain.entity.ItemEntity;
import com.example.taskmanagerapi.domain.entity.ItemList;
import com.example.taskmanagerapi.domain.entity.ListEntity;
import com.example.taskmanagerapi.domain.repository.ItemListRepository;
import com.example.taskmanagerapi.domain.repository.ItemRepository;
import com.example.taskmanagerapi.domain.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<ListWithItemsDTO> getAll() {
        List<ItemList> itemLists = itemListRepository.findAll();

        Map<Long, ListWithItemsDTO> map = new HashMap<>();

        for (ItemList itemList: itemLists) {
            Long listId = itemList.getList().getId();

            if (!map.containsKey(listId)) {
                ListWithItemsDTO dto = new ListWithItemsDTO();
                dto.setListId(listId);
                dto.setListName(itemList.getList().getName());
                dto.setItems(new ArrayList<>());
                map.put(listId, dto);
            }

            ListWithItemsDTO dto = map.get(listId);
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(itemList.getItem().getId());
            itemDTO.setTitle(itemList.getItem().getTitle());
            itemDTO.setDescription(itemList.getItem().getDescription());
            itemDTO.setIsCompleted(itemList.getItem().getIsCompleted());
            itemDTO.setIsPriority(itemList.getItem().getIsPriority());
            dto.getItems().add(itemDTO);
        }

        return new ArrayList<>(map.values());
    }

    public ItemList associateItemToList(Long itemId, Long listId) {
        ItemEntity item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("List not found"));

        Optional<ItemList> existingItemList = itemListRepository.findByItemAndList(itemId, listId);
        System.out.println(existingItemList);
        if (existingItemList.isPresent()) {
            throw new ItemAlreadyInListException("List is already associated with this list");
        }

        ItemList itemListEntity = new ItemList(item, list);
        return itemListRepository.save(itemListEntity);
    }

}
