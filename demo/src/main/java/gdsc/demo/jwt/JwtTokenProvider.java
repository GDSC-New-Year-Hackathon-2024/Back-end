package gdsc.demo.jwt;//package com.hisujung.web.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import jakarta.annotation.PostConstruct;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//@Slf4j
//@Component
//public class JwtTokenProvider {
//
//    private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 60 * 10; // 10시간
//
//    @Value("${jwt.secret}")
//    private String secretKey;
//
//
//    private final UserDetailsService userDetailsService;
//    @Lazy
//    public JwtTokenProvider(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    // Jwt 토큰 생성
//    public String createToken(String userPk, List<String> roles) {
//        Claims claims = Jwts.claims().setSubject(userPk);
//        claims.put("roles", roles);
//        Date now = new Date();
//        return Jwts.builder()
//                .setClaims(claims) // 데이터
//                .setIssuedAt(now)   // 토큰 발행 일자
//                .setExpiration(new Date(now.getTime() + TOKEN_VALID_MILISECOND)) // 만료 기간
//                .signWith(SignatureAlgorithm.HS512, secretKey) // 암호화 알고리즘, secret 값
//                .compact(); // Token 생성
//    }
//
//    // 인증 성공시 SecurityContextHolder에 저장할 Authentication 객체 생성
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    // Jwt Token에서 User PK 추출
//    public String getUserPk(String token) {
//        return Jwts.parser().setSigningKey(secretKey)
//                .parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        return req.getHeader("X-AUTH-TOKEN");
//    }
//
//    // Jwt Token의 유효성 및 만료 기간 검사
//    public boolean validateToken(String jwtToken) {
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}