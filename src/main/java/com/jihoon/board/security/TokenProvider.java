package com.jihoon.board.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// JWT: 전자 서명이 된 토큰
// JSON 형태로 구성된 토큰
// {header}.{payload}.{signature}

// header: typ (해당 토큰의 타입), alg (토큰을 서명하기 위해 사용된 해시 알고리즘)
// payload: sub (해당 토큰의 주인), iat (토큰이 발행된 시간), exp (토큰이 만료되는 시간)

@Service
public class TokenProvider {
	// JWT 생성 및 검증을 위한 키
	private static final String SECURITY_KEY = "jwtseckey!@";
	
	// JWT 생성하는 메서드
	public String create (String userEmail) {
		// 만료날짜를 현재 날짜 + 1시간으로 설정
		Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
		
		// JWT를 생성
		return Jwts.builder()
				// 암호화에 사용될 알고리즘, 키
				.signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
				// JWT 제목, 생성일, 만료일
				.setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
				// 생성
				.compact();
	}
	
	// JWT 검증
	public String validate (String token) {
		// 매개변수로 받은 token을 키를 사용해서 복호화 (디코딩)
		Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
		// 복호화된 토큰의 payload에서 제목을 가져옴
		return claims.getSubject();
	}
}
