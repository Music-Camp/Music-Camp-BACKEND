package com.MusicCamp.backend.post.dto;


import com.MusicCamp.backend.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostDetailResDto {
    private Long postId;
    private Long userId;
    private String nickName;
    private String title;
    private String content;
    private String imageURL;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static PostDetailResDto of(Post post){
        return new PostDetailResDto(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getNickname(),
                post.getTitle(),
                post.getContent(),
                post.getImageUrl(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
