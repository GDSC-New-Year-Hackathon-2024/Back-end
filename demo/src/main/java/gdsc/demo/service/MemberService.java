package gdsc.demo.service;

import gdsc.demo.dto.user.UserSignupRequestDto;

public interface MemberService {
    //회원가입
    public Long signUp(UserSignupRequestDto requestDro) throws Exception;
    public Long join(UserSignupRequestDto requestDto) throws Exception;
    //public String login(Map<String, String> members);
}
