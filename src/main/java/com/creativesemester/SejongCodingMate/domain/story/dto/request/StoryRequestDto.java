package com.creativesemester.SejongCodingMate.domain.story.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class StoryRequestDto {

    @NotNull
    private Long chapterId;

    @NotNull
    private Long nextId;

    @NotNull
    private Long previousId;

    @NotNull
    private Long formatId;

    @NotBlank()
    private String content;

    @NotBlank()
    private String backgroundImage;

}
