package com.MusicCamp.backend.attendance;


import com.MusicCamp.backend.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/attendance/{userId}")
    public BaseResponse<Void> changeAttendance(@PathVariable Long userId,@RequestBody Boolean isAttendance)  {

        attendanceService.changeAttendance(userId,isAttendance);
        return  BaseResponse.success();
    }
}
