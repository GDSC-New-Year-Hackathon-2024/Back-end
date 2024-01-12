package gdsc.demo.dto;

import gdsc.demo.domain.CheckList;
import gdsc.demo.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckListSaveRequestDto {

    private String category;

    @Builder
    public CheckListSaveRequestDto(String category) {
        this.category = category;
    }

    public CheckList toEntity(User user) {
        return CheckList.builder()
                .user(user)
                .category(category)
                .build();
    }
}
