package com.creativesemester.SejongCodingMate.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Role {
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN");

	private final String role;
	private static final Map<String, Role> roleMap = Stream.of(values()).collect(Collectors.toMap(Role::getRole, role -> role));

	public static Role of(String role) {
		if (roleMap.get(role) == null) {
			throw new IllegalArgumentException("Invalid role: " + role);
		}
		return roleMap.get(role);
	}
}
