package com.MusicCamp.backend.post;


import com.MusicCamp.backend.config.BaseResponse;
import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public BaseResponse<Void> createPost(@PathVariable PostCreateReqDto postCreateReqDto){
        postService.createPost(postCreateReqDto);
        return BaseResponse.success();
    }

}
