package com.MusicCamp.backend.comment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentUpdateReqDto {
    private Long commentId;
    private String content;
}
