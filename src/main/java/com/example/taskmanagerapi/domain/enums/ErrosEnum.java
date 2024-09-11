package com.example.taskmanagerapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrosEnum {
    ASSOCIATION_ALREADY_EXIST("Association already exist", HttpStatus.NOT_FOUND);
    private final String message;
    private final HttpStatus status;
}
