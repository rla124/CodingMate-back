package com.creativesemester.SejongCodingMate.global.jwt;

import com.creativesemester.SejongCodingMate.domain.member.entity.Role;
import com.creativesemester.SejongCodingMate.global.response.ErrorType;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String token = jwtUtil.resolveToken(request);

		if (token == null) {
			request.setAttribute("exception", ErrorType.TOKEN_NOT_FOUND);
			filterChain.doFilter(request, response);
			return;
		}

		if (!jwtUtil.validateToken(token)) {
			request.setAttribute("exception", ErrorType.NOT_VALID_TOKEN);
			filterChain.doFilter(request, response);
			return;
		}


		try {
			setAuthentication(token); // Claims.getSubject() : accessToken 만들 때의 .setSubject("MemberInfo") 반환
		} catch (UsernameNotFoundException e) {
			request.setAttribute("exception", ErrorType.USER_NOT_FOUND);
		}

		filterChain.doFilter(request, response);
	}

	private void setAuthentication(String token) {
		Claims info = jwtUtil.getUserInfoFromToken(token);
		String userEmail = info.get("email", String.class);
		Role role = Role.of(info.get("role", String.class));
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		Authentication authentication = jwtUtil.createAuthentication(userEmail, role);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);
	}

}
