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
	private String name;
	private String accessToken;
	private String refreshToken;


	public static MemberResponseDto of(Long storyId, Long chapterId, Boolean hasTemporaryPassword, String name,
									   String accessToken, String refreshToken) {
		return MemberResponseDto.builder()
			.storyId(storyId)
			.chapterId(chapterId)
			.hasTemporaryPassword(hasTemporaryPassword)
			.name(name)
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}
}
