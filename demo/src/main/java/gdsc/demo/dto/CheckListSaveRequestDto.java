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

    private String contents;

    @Builder
    public CheckListSaveRequestDto(String category, String contents) {
        this.category = category;
        this.contents = contents;
    }

    public CheckList toEntity(User user) {
        return CheckList.builder()
                .user(user)
                .category(category)
                .contents(contents)
                .build();
    }
}
