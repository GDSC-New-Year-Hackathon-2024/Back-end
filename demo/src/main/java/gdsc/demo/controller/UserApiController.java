package gdsc.demo.controller;

import gdsc.demo.dto.user.UserSignupRequestDto;
import gdsc.demo.service.MemberService;
import gdsc.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

