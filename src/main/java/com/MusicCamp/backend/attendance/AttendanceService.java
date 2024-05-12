package com.MusicCamp.backend.attendance;


import com.MusicCamp.backend.likes.Likes;
import com.MusicCamp.backend.post.Post;
import com.MusicCamp.backend.user.User;
import com.MusicCamp.backend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;
    public void changeAttendance(Long userId,boolean isAttendance) {
        User user = userRepository.findById(userId).get();
        try {
            Attendance attendance = attendanceRepository.findByUser(user).get();
        }catch (Exception e){
            Attendance attendance = new Attendance(user, isAttendance);
            attendanceRepository.save(attendance);
        }
        // 값이 있는 경우 출석 변경
        Attendance attendance = attendanceRepository.findByUser(user).get();
        attendance.modify(isAttendance);

    }
}
