package com.creativesemester.SejongCodingMate.global.jwt;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

	@NotBlank(message = "accessToken은 null일 수 없습니다.")
	private String accessToken;

	@NotBlank(message = "refreshToken은 null일 수 없습니다.")
	private String refreshToken;

	public static TokenDto of(String accessToken, String refreshToken) {
		return TokenDto.builder()
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}

}
