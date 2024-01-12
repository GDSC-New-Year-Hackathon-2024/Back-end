package gdsc.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentUpdateDto {

    //0이면 종료x, 1이면 종료o
    private int isDone;

    @Builder
    public ContentUpdateDto(int isDone) {
        this.isDone = isDone;
    }
}