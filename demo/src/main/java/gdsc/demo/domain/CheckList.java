package gdsc.demo.domain;

import gdsc.demo.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class CheckList extends BaseTimeEntity {

    @Id
    @Column(name = "check_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 체크리스트 카테고리
    private String category;

    private String contents;


    public void update(String category) {
        this.category = category;
    }
}
