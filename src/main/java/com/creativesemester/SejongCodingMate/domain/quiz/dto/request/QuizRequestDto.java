package com.creativesemester.SejongCodingMate.domain.quiz.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class QuizRequestDto {

    @NotBlank()
    private String text;
    @NotBlank()
    private String answer;
    @NotBlank()
    private String description;


    @NotNull
    private Long storyId;
    @NotNull
    private Long quizId;
    @NotNull
    private Long formatId;

}
