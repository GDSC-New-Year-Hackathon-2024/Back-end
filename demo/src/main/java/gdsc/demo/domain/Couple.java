package gdsc.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Couple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couple_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @OneToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    private LocalDateTime firstMetDate;

    @Builder.Default
    private int Level = 1;

    @Builder.Default
    private int totalPoint=0;



}