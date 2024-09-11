package com.example.taskmanagerapi.api.exception;

import com.example.taskmanagerapi.domain.enums.ErrosEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException {
    private final ErrosEnum errorsEnum;
}
