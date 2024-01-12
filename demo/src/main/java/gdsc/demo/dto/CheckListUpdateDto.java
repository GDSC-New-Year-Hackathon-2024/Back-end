package gdsc.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckListUpdateDto {
    private String category;

    @Builder
    public CheckListUpdateDto(String category) {
        this.category = category;
    }
}
