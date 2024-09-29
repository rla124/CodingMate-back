package com.creativesemester.SejongCodingMate.domain.story.dto.request;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class SaveStoryRequestDto {

    @NotBlank()
    private Long nextStoryId;

}
