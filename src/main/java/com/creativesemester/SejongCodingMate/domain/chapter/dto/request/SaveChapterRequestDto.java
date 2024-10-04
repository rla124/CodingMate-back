package com.creativesemester.SejongCodingMate.domain.chapter.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class SaveChapterRequestDto {

    @NotNull
    private Long nextChapterId;

}
