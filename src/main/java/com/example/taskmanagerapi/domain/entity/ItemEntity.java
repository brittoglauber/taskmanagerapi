package com.example.taskmanagerapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isCompleted = false;

    @Column(nullable = false)
    private Boolean isPriority = false;

    public ItemEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
