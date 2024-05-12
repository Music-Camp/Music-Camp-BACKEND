package com.MusicCamp.backend.attendance.dto;


import com.MusicCamp.backend.attendance.Attendance;
import com.MusicCamp.backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AttendanceAllResDto {
    private Long id;
    private Long userId;
    private String nickName;
    private String profileUrl;
    private Boolean isAttendance;

    public static AttendanceAllResDto of(Attendance attendance){
        return new AttendanceAllResDto(
                attendance.getId(),
                attendance.getUser().getId(),
                attendance.getNickName(),
                attendance.getProfileUrl(),
                attendance.getIsAttendance()
        );
    }
}
