package com.creativesemester.SejongCodingMate.domain.chapter.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class ChapterRequestDto {

    @NotNull(message = "챕터 번호를 알려주세요.")
    private Long chapterNumber;

    @NotNull(message = "첫번째 스토리 ID를 알려주세요.")
    private Long firstStoryId;

    @NotNull(message = "첫번째 스토리 ID를 알려주세요.")
    private Long lastStoryId;

    @NotBlank(message = "챕터 제목을 알려주세요.")
    private String title;

    @NotBlank(message = "캐릭터 이미지 Url을 알려주세요.")
    private String url;

}
