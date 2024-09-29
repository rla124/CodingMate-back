package com.creativesemester.SejongCodingMate.domain.member.controller;


import com.creativesemester.SejongCodingMate.domain.member.dto.request.MemberIdRequestDto;
import com.creativesemester.SejongCodingMate.domain.member.dto.request.MemberRequestDto;
import com.creativesemester.SejongCodingMate.domain.member.service.MemberService;
import com.creativesemester.SejongCodingMate.global.jwt.TokenDto;
import com.creativesemester.SejongCodingMate.global.response.GlobalResponseDto;
import com.creativesemester.SejongCodingMate.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {


	private final MemberService memberService;

	@PostMapping("/sign-up")
	public ResponseEntity<GlobalResponseDto> signUp(@RequestBody @Valid MemberRequestDto memberRequestDto) {
		return memberService.signUp(memberRequestDto);
	}

	@PostMapping("/login")
	public ResponseEntity<GlobalResponseDto> login(@RequestBody @Valid MemberRequestDto memberRequestDto,
												   HttpServletResponse response) {
		return memberService.login(memberRequestDto, response);
	}

	@PatchMapping("/password")
	public ResponseEntity<GlobalResponseDto> changePassword(@RequestBody @Valid MemberRequestDto memberRequestDto) {
		return memberService.changePassword(memberRequestDto);
	}

	@GetMapping("/{memberId}")
	public ResponseEntity<GlobalResponseDto> isExistMember(@PathVariable String memberId) {
		return memberService.isExistMember(memberId);
	}

	@PatchMapping("/temporary")
	public ResponseEntity<GlobalResponseDto> sendPasswordEmail(@RequestBody @Valid MemberIdRequestDto memberIdRequestDto) {
		return memberService.sendPasswordEmail(memberIdRequestDto);
	}

	@PostMapping("/reissue")
	public ResponseEntity<GlobalResponseDto> reissueTokenPair(@AuthenticationPrincipal UserDetailsImpl userDetails,
															  @RequestBody @Valid TokenDto tokenDto) {
		return memberService.reissueTokenPair(userDetails.getMember(), tokenDto);
	}
}
