package com.example.taskmanagerapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_list")
@Data
@NoArgsConstructor
public class ItemList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListEntity list;

    public ItemList(ItemEntity item, ListEntity list) {
        this.item = item;
        this.list = list;
    }
}
