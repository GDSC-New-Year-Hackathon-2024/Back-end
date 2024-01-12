package gdsc.demo.repository;

import gdsc.demo.domain.CheckList;
import gdsc.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {

    Optional<CheckList> findById(Long id);
    List<CheckList> findByUser(User user);

}
