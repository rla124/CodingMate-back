package com.creativesemester.SejongCodingMate.domain.dialogue.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class DialogueRequestDto {

    @NotNull
    private Long storyId;
    @NotBlank()
    private String speaker;
    @NotBlank()
    private String text;
    @NotNull
    private Long soundEffect;
    @NotNull
    private Long screenEffect;
    @NotBlank()
    private String characterImage;

}
