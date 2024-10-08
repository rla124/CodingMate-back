package com.creativesemester.SejongCodingMate.domain.member.repository;

import com.creativesemester.SejongCodingMate.domain.member.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByMemberId(Long memberId);
}
