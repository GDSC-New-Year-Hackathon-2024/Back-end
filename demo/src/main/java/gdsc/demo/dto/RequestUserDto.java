package gdsc.demo.dto;

import lombok.Data;

@Data
public class RequestUserDto {
    private Integer age;
    private Integer gender;
    private String mbti;
    private String nickname;
}