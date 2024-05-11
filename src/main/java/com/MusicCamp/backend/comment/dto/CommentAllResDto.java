package com.MusicCamp.backend.comment.dto;

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
}
