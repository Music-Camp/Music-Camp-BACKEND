package com.MusicCamp.backend.attendance;

import com.MusicCamp.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

    Optional<Attendance> findByUser(User user);

}
