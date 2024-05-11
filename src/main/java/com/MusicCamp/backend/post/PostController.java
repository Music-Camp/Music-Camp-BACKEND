package com.MusicCamp.backend.post;


import com.MusicCamp.backend.config.BaseResponse;
import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import com.MusicCamp.backend.post.dto.PostUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/post")
    public  BaseResponse<Void> updatePost(@PathVariable Long postId,PostUpdateReqDto postUpdateReqDto){
        postService.updatePost(postId,postUpdateReqDto);
        return BaseResponse.success();
    }

}
