package gdsc.demo.service;

import gdsc.demo.domain.CheckList;
import gdsc.demo.domain.User;
import gdsc.demo.dto.CheckListResponseDto;
import gdsc.demo.dto.CheckListSaveRequestDto;
import gdsc.demo.dto.CheckListUpdateDto;
import gdsc.demo.repository.CheckListRepository;
import gdsc.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CheckListService {

    private final UserRepository userRepository;
    private final CheckListRepository checkListRepository;

    @Transactional
    public Long save(User user, CheckListSaveRequestDto requestDto) {

        return checkListRepository.save(requestDto.toEntity(user)).getId();
    }

    @Transactional
    public Long update(Long id, CheckListUpdateDto requestDto) {
        CheckList checkList = checkListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 체크리스트가 존재하지 않습니다."));

        checkList.update(requestDto.getCategory());

        return id;
    }

    @Transactional
    public void deleteCheckList(Long id) {
        CheckList checkList = checkListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 체크리스트가 존재하지 않습니다."));
        checkListRepository.delete(checkList);

    }


//    public CheckListResponseDto findById(Long id) {
//
//    }

    //회원의 체크리스트 조회
    public List<CheckListResponseDto> findByUser(User user) {

        //Long userId = user.getId();

        //List<CheckList> checkLists = checkListRepository.findByUser(user);
        //List<CheckListResponseDto> resultList = new ArrayList<>();

//        for(CheckList c: checkLists) {
//            resultList.add(new CheckListResponseDto(c));
//        }
//
//        return resultList;
        return checkListRepository.findByUser(user).stream().map(CheckListResponseDto::new).collect(Collectors.toList());
    }

    //기본키인 id로 체크리스트 조회
    public List<CheckListResponseDto> findById(Long id) {
        return checkListRepository.findById(id).stream().map(CheckListResponseDto::new).collect(Collectors.toList());
    }
}
