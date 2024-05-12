package com.MusicCamp.backend.attendance;
import com.MusicCamp.backend.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String nickName;
    private String profileUrl;
    private Boolean isAttendance;

    public Attendance(User user,Boolean isAttendance){
           this.user=user;
           this.nickName=user.getNickname();
           this.profileUrl= user.getImageUrl();
           this.isAttendance=isAttendance;
    }

    public void modify(Boolean isAttendance){
        this.isAttendance=isAttendance;
    }

}
