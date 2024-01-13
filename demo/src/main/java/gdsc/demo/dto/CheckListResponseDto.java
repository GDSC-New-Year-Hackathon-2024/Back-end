package gdsc.demo.dto;

import gdsc.demo.domain.CheckList;
import lombok.Getter;

@Getter
public class CheckListResponseDto {

    private Long id;
    private String category;
    private String contents;

    public CheckListResponseDto(CheckList entity) {
        this.id = entity.getId();
        this.category = entity.getCategory();
        this.contents = entity.getContents();
    }

//    public CheckListResponseDto(CheckList entity, int is) {
//        this.id = entity.getId();
//        this.category = entity.getCategory();
//    }
}
