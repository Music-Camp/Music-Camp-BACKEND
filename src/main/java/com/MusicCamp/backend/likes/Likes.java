package com.MusicCamp.backend.likes;
import com.MusicCamp.backend.post.Post;
import com.MusicCamp.backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @Setter
    private Boolean isStatus;


    public Likes(User user, Post post, Boolean isStatus) {
        this.user = user;
        this.post = post;
        this.isStatus = isStatus;
    }
}
