package gdsc.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class ResponseCoupleDto {

    private RequestUserDto user1Nickname;
    private RequestUserDto user2Nickname;
    private Integer totalPoint;
}
