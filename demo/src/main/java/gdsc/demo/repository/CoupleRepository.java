package gdsc.demo.repository;

import gdsc.demo.domain.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoupleRepository extends JpaRepository<Couple,Long> {

    @Query("SELECT c FROM Couple c ORDER BY c.totalPoint DESC ")
    List<Couple> findUsersByTotalPoint();

}
