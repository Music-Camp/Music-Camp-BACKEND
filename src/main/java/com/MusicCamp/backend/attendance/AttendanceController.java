package com.MusicCamp.backend.attendance;


import com.MusicCamp.backend.attendance.dto.AttendanceAllResDto;
import com.MusicCamp.backend.config.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
@Tag(name = "AttendanceController",
        description = "출석 관련 기능을 담당합니다. path : localhost:8080/music/attendance로 시작합니다.")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/attendance/{userId}")
    public BaseResponse<Void> changeAttendance(@PathVariable Long userId,@RequestBody Boolean isAttendance)  {
        attendanceService.changeAttendance(userId,isAttendance);
        return  BaseResponse.success();
    }


    @GetMapping("/attendance")
    public BaseResponse<List<AttendanceAllResDto>> allAttendanceList(){
        List<AttendanceAllResDto> attendanceAllResDtos = attendanceService.allAttendanceList();
        return BaseResponse.success(attendanceAllResDtos);
    }

}
