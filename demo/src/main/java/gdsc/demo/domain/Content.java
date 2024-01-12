package gdsc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Content {
    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //체크리스트 항목 내용
    private String toDo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_list_id")
    private CheckList checkList;

    //해당 내용 달성 여부
    private int isDone;

    public void updateIsDone(int isDone) {
        this.isDone = isDone;
    }


}
