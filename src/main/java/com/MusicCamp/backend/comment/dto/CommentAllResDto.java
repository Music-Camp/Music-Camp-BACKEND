package com.MusicCamp.backend.comment.dto;

import com.MusicCamp.backend.comment.Comment;
import com.MusicCamp.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentAllResDto {
    private Long userId;
    private String nickname;
    private String content;
    private LocalDateTime createTime;


    public static CommentAllResDto of (Comment comment){
        return new CommentAllResDto(
                comment.getUser().getId(),
                comment.getContent(),
                comment.getContent(),
                comment.getCreatedAt()
        );
    }
}
