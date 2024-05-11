package com.MusicCamp.backend.post.dto;

import com.MusicCamp.backend.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostAllResDto {
    private Long postId;
    private Long userId;
    private String nickname;
    public  String title;

    public static PostAllResDto of(Post post){
        return new PostAllResDto(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getNickname(),
                post.getTitle()
                );
    }

}
