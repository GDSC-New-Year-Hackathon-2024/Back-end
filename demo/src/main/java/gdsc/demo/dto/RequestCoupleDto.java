package gdsc.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestCoupleDto {

    private String uniqueNumber1;
    private String uniqueNumber2;
    private LocalDateTime firstMetDate;
}
