package gdsc.demo.repository;

import gdsc.demo.domain.CheckList;
import gdsc.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {

    List<CheckList> findByUser(User user);

}
