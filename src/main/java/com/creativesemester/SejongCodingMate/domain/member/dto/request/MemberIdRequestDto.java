package com.creativesemester.SejongCodingMate.domain.member.dto.request;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class MemberIdRequestDto {

    @NotBlank(message = "ID를 입력해주세요.")
    private String memberId;

}
