package com.MusicCamp.backend.attendance;


import com.MusicCamp.backend.attendance.dto.AttendanceAllResDto;
import com.MusicCamp.backend.likes.Likes;
import com.MusicCamp.backend.post.Post;
import com.MusicCamp.backend.user.User;
import com.MusicCamp.backend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;
    public void changeAttendance(Long userId,boolean isAttendance) {
        User user = userRepository.findById(userId).get();
        // 값이 없으면 해당 값을 생성함
        try {
            Attendance attendance = attendanceRepository.findByUser(user).get();
        }catch (Exception e){
            Attendance attendance = new Attendance(user, isAttendance);
            attendanceRepository.save(attendance);
        }
        //이후 받은 출석 여부 값으로 변경해줌
        Attendance attendance = attendanceRepository.findByUser(user).get();
        attendance.modify(isAttendance);
    }

    public List<AttendanceAllResDto> allAttendanceList() {
        List<Attendance> attendanceList = attendanceRepository.findAll();
        List<AttendanceAllResDto> attendanceAllResDtoList = attendanceList.stream().map((eachAttendance) -> AttendanceAllResDto.of(eachAttendance)).toList();
        return attendanceAllResDtoList;
    }
}
