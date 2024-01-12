package gdsc.demo.dto;

import gdsc.demo.domain.CheckList;
import gdsc.demo.domain.Content;
import lombok.Getter;

@Getter
public class CheckListResponseDto {

    private Long id;
    private String category;
    private Content content;

    public CheckListResponseDto(CheckList entity) {
        this.id = entity.getId();
        this.category = entity.getCategory();
    }

//    public CheckListResponseDto(CheckList entity, int is) {
//        this.id = entity.getId();
//        this.category = entity.getCategory();
//    }
}
