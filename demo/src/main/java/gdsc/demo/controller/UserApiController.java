package gdsc.demo.controller;

import gdsc.demo.domain.User;
import gdsc.demo.dto.user.LoginRequestDto;
import gdsc.demo.dto.user.UserSignupRequestDto;
import gdsc.demo.jwt.JwtTokenUtil;
import gdsc.demo.service.MemberService;
import gdsc.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {
    @Autowired
    private Environment env;

    private final MemberService memberService;
    private final UserService userService;

    @Value("${jwt.secret}")
    private String secretKey;

    @PostMapping("/join")
    public Long join(@RequestBody UserSignupRequestDto requestDto) throws Exception {
        return memberService.join(requestDto);
        //return 1L;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = userService.login(loginRequestDto);

        if (user == null) {
            return ResponseEntity.badRequest().body("로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }

        long expireTimeMs = 1000 * 60 * 60 * 8; // Token 유효 시간 = 8시간
        String jwtToken = JwtTokenUtil.createToken(loginRequestDto.getEmail(), secretKey, expireTimeMs);

        // 사용자 정보를 JSON 형태로 리턴
        Map<String, Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("token", jwtToken);
        response.put("email", user.getEmail());
        response.put("username", user.getName());
        response.put("nickname", user.getNickname());
        response.put("age", user.getAge());
        response.put("gender", user.getGender());
        response.put("mbti", user.getMbti());
        response.put("totalPointUseAble", user.getTotalPointUseAble());


        log.info("hihihibye");
        return ResponseEntity.ok(response);
    }
}

