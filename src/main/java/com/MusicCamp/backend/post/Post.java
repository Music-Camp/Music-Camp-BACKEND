package com.MusicCamp.backend.post;
import com.MusicCamp.backend.comment.Comment;
import com.MusicCamp.backend.likes.Likes;
import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import com.MusicCamp.backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 100)
    private String title;

    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Likes> likesList = new ArrayList<>();

    public Post(User user, PostCreateReqDto postCreateReqDto) {
        this.user = user;
        this.title = postCreateReqDto.getTitle();
        this.content = postCreateReqDto.getContent();
        this.imageUrl = postCreateReqDto.getImageUrl();
    }

}