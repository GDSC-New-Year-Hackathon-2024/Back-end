package gdsc.demo.controller;

import gdsc.demo.domain.User;
import gdsc.demo.dto.CheckListResponseDto;
import gdsc.demo.dto.CheckListSaveRequestDto;
import gdsc.demo.dto.CheckListUpdateDto;
import gdsc.demo.responseType.ApiResponse;
import gdsc.demo.service.CheckListService;
import gdsc.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/checklist")
public class CheckListApiController {

    private final CheckListService checkListService;
    private final UserService userService;

    // 회원의 체크리스트 생성
    @PostMapping("/new")
    public ApiResponse<Long> save(@RequestBody CheckListSaveRequestDto checkListSaveRequestDto, Authentication auth) {

        User user = userService.getLoginUserByLoginId(auth.getName());

        Long result = checkListService.save(user, checkListSaveRequestDto);

        if(result == -1L) {
            return (ApiResponse<Long>) ApiResponse.createError("체크리스트 업데이트에 실패했습니다.");
        }

        return ApiResponse.createSuccess(result);

    }

    //회원의 체크리스트 업데이트
    @PostMapping("/update/id")
    public ApiResponse<Long> update(@RequestParam Long id, @RequestBody CheckListUpdateDto requestDto) {
        Long result = checkListService.update(id, requestDto);
        if(result == -1L) {
            return (ApiResponse<Long>) ApiResponse.createError("포트폴리오 업데이트에 실패했습니다.");
        }
        return ApiResponse.createSuccess(result);
    }

    //체크리스트 하나 조회
    @GetMapping("/id")
    public ApiResponse<CheckListResponseDto> findById(@RequestParam Long id) {
        CheckListResponseDto result = checkListService.findById(id);

        if(result == null) {
            return (ApiResponse<CheckListResponseDto>) ApiResponse.createError("포트폴리오 업데이트에 실패했습니다.");
        }

        return ApiResponse.createSuccess(result);

    }

    //회원의 체크리스트 전체 조회
    @GetMapping("/all")
    public ApiResponse<List<CheckListResponseDto>> findByUser(Authentication auth) {
        User user = userService.getLoginUserByLoginId(auth.getName());

        if(user == null) {
            return (ApiResponse<List<CheckListResponseDto>>)ApiResponse.createError("회원 조회에 실패하였습니다.");
        }
        List<CheckListResponseDto> resultList = checkListService.findByUser(user);
        if(resultList == null) {
            return (ApiResponse<List<CheckListResponseDto>>)ApiResponse.createError("포트폴리오가 존재하지 않습니다.");
        }
        return ApiResponse.createSuccess(resultList);

    }



}
