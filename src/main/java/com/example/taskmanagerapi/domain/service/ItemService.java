package com.example.taskmanagerapi.domain.service;

import com.example.taskmanagerapi.domain.dto.ItemRequestSaveDTO;
import com.example.taskmanagerapi.domain.entity.ItemEntity;
import com.example.taskmanagerapi.domain.entity.ListEntity;
import com.example.taskmanagerapi.domain.repository.ItemRepository;
import com.example.taskmanagerapi.domain.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListRepository listRepository;

    public ItemService (ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemEntity createItem(ItemRequestSaveDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity(
                itemDTO.getTitle(),
                itemDTO.getDescription()
        );
        itemEntity.setIsCompleted(itemDTO.getIsCompleted());
        itemEntity.setIsPriority(itemDTO.getIsPriority());

        return itemRepository.save(itemEntity);
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity getItemById(Long id) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(id);
        return itemEntity.orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public ItemEntity updateItem(Long id, ItemEntity itemEntity) {
        ItemEntity oldItemEntity = itemRepository.findById(id).get();

        if (oldItemEntity == null) {
            throw new RuntimeException("Item not found");
        }

        oldItemEntity.setDescription(itemEntity.getDescription());
        oldItemEntity.setTitle(itemEntity.getTitle());
        oldItemEntity.setIsCompleted(itemEntity.getIsCompleted());
        oldItemEntity.setIsPriority(itemEntity.getIsPriority());
        return itemRepository.save(itemEntity);
    }

    public void deleteItem(Long id) {
        ItemEntity itemEntity = itemRepository.findById(id).get();
        if (itemEntity == null) {
            throw new RuntimeException("Item not found");
        }

        itemRepository.delete(itemEntity);
    }
}
