package com.creativesemester.SejongCodingMate.domain.story.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class SaveStoryRequestDto {

    @NotNull
    private Long nextStoryId;

}
