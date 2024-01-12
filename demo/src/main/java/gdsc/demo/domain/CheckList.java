package gdsc.demo.domain;

import gdsc.demo.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
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

    @OneToMany(mappedBy = "checkList", cascade = CascadeType.ALL)
    private List<Content> contentList;

    @Builder
    public CheckList(User user, String category) {
        this.user = user;
        this.category = category;
    }

    public void update(String category) {
        this.category = category;
    }
}
