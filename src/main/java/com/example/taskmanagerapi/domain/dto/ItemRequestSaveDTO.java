package com.example.taskmanagerapi.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestSaveDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Boolean isCompleted;

    @NotNull
    private Boolean isPriority;


}
