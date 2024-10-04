package com.creativesemester.SejongCodingMate.domain.code.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class CodeExecuteRequestDto {

    @NotBlank()
    private String code;
    @NotBlank()
    private String input;

    @NotNull
    private Long storyId;

}
