package com.creativesemester.SejongCodingMate.domain.member.repository;

import com.creativesemester.SejongCodingMate.domain.member.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
}
