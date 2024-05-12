package com.MusicCamp.backend.post.dto;

import com.MusicCamp.backend.likes.Likes;
import com.MusicCamp.backend.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


/**
 프론트 요청에 따라 전체 조회에서도 PostAllResDto 대신 PostDetailResDto를 사용하기로 함-24/5/12일-
 **/
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
