package com.creativesemester.SejongCodingMate.domain.code.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class CodeRequestDto {

    @NotNull
    private String code;
    @NotNull
    private String text;
    @NotNull
    private String hint;
    @NotNull
    private String answer;
    @NotNull
    private String characterImage;
    @NotNull
    private String itemImage;
    @NotNull
    private String input;

    @NotBlank()
    private Long storyId;

}
