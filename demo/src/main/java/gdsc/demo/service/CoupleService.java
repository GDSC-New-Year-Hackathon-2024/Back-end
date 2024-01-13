package gdsc.demo.service;

import gdsc.demo.domain.Couple;
import gdsc.demo.domain.User;
import gdsc.demo.dto.RequestCoupleDto;
import gdsc.demo.repository.CoupleRepository;
import gdsc.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoupleService {

    private final CoupleRepository coupleRepository;
    private final UserRepository userRepository;

    @Transactional
    public String createCouple(RequestCoupleDto requestCoupleDto){
        User user1 = findUser(requestCoupleDto.getUniqueNumber1());
        User user2 = findUser(requestCoupleDto.getUniqueNumber2());

        Couple couple= Couple.builder()
                .user1(user1)
                .user2(user2)
                .firstMetDate(requestCoupleDto.getFirstMetDate())
                .build();
        coupleRepository.save(couple);
        return "커플 완성!";
    }

    @Transactional(readOnly = true)
    public List<Couple> findCoupleRanking(){
        return coupleRepository.findUsersByTotalPoint();
    }


    private User findUser(String num){
        return userRepository.findUserByUniqueNumber(num).orElseThrow(()-> new IllegalArgumentException("다시 확인해주세요"));
    }


}
