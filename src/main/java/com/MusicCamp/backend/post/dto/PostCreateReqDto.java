package com.MusicCamp.backend.post.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateReqDto {

    private Long userId;
    private String title;
    private String content;
    private String imageUrl;
}
