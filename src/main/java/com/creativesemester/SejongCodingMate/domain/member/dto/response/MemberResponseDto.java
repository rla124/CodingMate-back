package com.creativesemester.SejongCodingMate.domain.member.dto.response;

import com.creativesemester.SejongCodingMate.global.jwt.TokenDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {

	private Long storyId;
	private Long chapterId;
	private Boolean hasTemporaryPassword;
	private String accessToken;
	private String refreshToken;


	public static MemberResponseDto of(Long storyId, Long chapterId, Boolean hasTemporaryPassword,
									   String accessToken, String refreshToken) {
		return MemberResponseDto.builder()
			.storyId(storyId)
			.chapterId(chapterId)
			.hasTemporaryPassword(hasTemporaryPassword)
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}
}
