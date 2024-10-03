package com.creativesemester.SejongCodingMate.domain.member.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class MemberRequestDto {
	@NotNull
	private Boolean isAdmin;

	@NotBlank(message = "ID를 입력해주세요.")
	private String memberId;

	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String password;

}
