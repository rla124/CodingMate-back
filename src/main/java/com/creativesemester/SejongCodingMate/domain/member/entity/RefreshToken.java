package com.creativesemester.SejongCodingMate.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@RedisHash(value = "refreshToken")
public class RefreshToken {

	@Id
	private Long memberId;
	private String token;
	@TimeToLive
	private final long ttl;

	@Builder
	public RefreshToken(Long memberId, String token, long ttl) {
		this.memberId = memberId;
		this.token = token;
		this.ttl = ttl;
	}

	public void updateToken(String newRefreshToken) {
		this.token = newRefreshToken;
	}
}
