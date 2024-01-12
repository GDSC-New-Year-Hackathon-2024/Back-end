package gdsc.demo.dto.user;

import gdsc.demo.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSignupRequestDto {

    private String email;

    private String password;

    private String name;

    private int age;

    //0 은 남자, 1은 여자
    private int gender;

    private String mbti;

    private String nickname;

    private int totalPointUserAble;

    @Builder
    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .age(age)
                .gender(gender)
                .mbti(mbti)
                .nickname(nickname)
                .totalPointUseAble(totalPointUserAble)
                .build();
    }
}
