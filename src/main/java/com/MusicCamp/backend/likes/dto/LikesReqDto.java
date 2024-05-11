package com.MusicCamp.backend.likes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@AllArgsConstructor
public class LikesReqDto {
    private  Long userId;
    private Long postId;
}
