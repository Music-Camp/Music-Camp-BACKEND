package com.MusicCamp.backend.comment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateReqDto {
    Long userId;
    String content;
}
