package com.creativesemester.SejongCodingMate.domain.chapter.dto.request;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class SaveChapterRequestDto {

    @NotBlank()
    private Long nextChapterId;

}
