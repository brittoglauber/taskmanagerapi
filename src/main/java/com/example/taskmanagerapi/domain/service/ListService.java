package com.example.taskmanagerapi.domain.service;

import com.example.taskmanagerapi.domain.entity.ListEntity;
import com.example.taskmanagerapi.domain.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public ListEntity createList(ListEntity listEntity) {
        return listRepository.save(listEntity);
    }

    public List<ListEntity> getAllLists() {
        return listRepository.findAll();
    }

    public ListEntity getListById(Long id) {
        Optional<ListEntity> listEntity = listRepository.findById(id);
        return listEntity.orElseThrow(() -> new RuntimeException("List not found"));
    }

    public ListEntity updateList(Long id, ListEntity listEntityDetails) {
        ListEntity listEntity = getListById(id);

        listEntity.setName(listEntityDetails.getName());

        return listRepository.save(listEntity);
    }

    public void deleteList(Long id) {
        ListEntity listEntity = getListById(id);
        listRepository.delete(listEntity);
    }
}
