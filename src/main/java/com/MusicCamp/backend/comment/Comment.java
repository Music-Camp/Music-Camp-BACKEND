package com.MusicCamp.backend.comment;
import com.MusicCamp.backend.comment.dto.CommentCreateReqDto;
import com.MusicCamp.backend.post.Post;
import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import com.MusicCamp.backend.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Comment(User user, Post post, CommentCreateReqDto commentCreateReqDto){
       this.user=user;
       this.post=post;
       this.content=commentCreateReqDto.getContent();
    }

}
