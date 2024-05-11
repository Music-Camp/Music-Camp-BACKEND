package com.MusicCamp.backend.post.dto;

import com.MusicCamp.backend.likes.Likes;
import com.MusicCamp.backend.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostAllResDto {
    private Long postId;
    private Long userId;
    private String nickname;
    private String title;
    private Long likesNum;

    public static PostAllResDto of(Post post){
        List<Likes> likesList = post.getLikesList();
        long count= 0;
        for(Likes likes:likesList){
            if(likes.getIsStatus()==true){
                count++;
            }
        }

        return new PostAllResDto(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getNickname(),
                post.getTitle(),
                count
                );
    }

}
