package com.MusicCamp.backend.post.dto;


import com.MusicCamp.backend.likes.Likes;
import com.MusicCamp.backend.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@AllArgsConstructor
public class PostDetailResDto {
    private Long postId;
    private Long userId;
    private String nickName;
    private String title;
    private String content;
    private String imageURL;
    private Long likeNum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static PostDetailResDto of(Post post){
        List<Likes> likesList = post.getLikesList();
        long count= 0;
        for(Likes likes:likesList){
            if(likes.getIsStatus()==true){
                count++;
            }
        }
        return new PostDetailResDto(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getNickname(),
                post.getTitle(),
                post.getContent(),
                post.getImageUrl(),
                count,
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
