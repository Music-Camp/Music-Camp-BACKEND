package com.MusicCamp.backend.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostUpdateReqDto {

    private String title;
    private String content;
    private String imageUrl;
}
