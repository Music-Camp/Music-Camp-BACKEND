package com.MusicCamp.backend.post;


import com.MusicCamp.backend.config.BaseResponse;
import com.MusicCamp.backend.post.dto.PostAllResDto;
import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import com.MusicCamp.backend.post.dto.PostDetailResDto;
import com.MusicCamp.backend.post.dto.PostUpdateReqDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
@Tag(name = "PostController",
        description = "게시판 관련 기능을 담당합니다. path : localhost:8080/music/post로 시작합니다.")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public BaseResponse<Void> createPost(@RequestBody PostCreateReqDto postCreateReqDto){
        postService.createPost(postCreateReqDto);
        return BaseResponse.success();
    }

    @PutMapping("/post/{postId}")
    public BaseResponse<Void> updatePost(@PathVariable Long postId,@RequestBody PostUpdateReqDto postUpdateReqDto){
        postService.updatePost(postId,postUpdateReqDto);
        return BaseResponse.success();
    }

    @GetMapping("/post")
    public BaseResponse<List<PostAllResDto>> getAllPost(){
        List<PostAllResDto> postAllResDtosList = postService.getAllPost();
        return BaseResponse.success(postAllResDtosList);
    }

    @GetMapping("/post/{postId}")
    public BaseResponse<PostDetailResDto> getPost(@PathVariable Long postId){
        PostDetailResDto postDetailResDto = postService.getPost(postId);
        return BaseResponse.success(postDetailResDto);
    }

    @DeleteMapping("/post/{postId}")
    public BaseResponse<Void> deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
        return BaseResponse.success();
    }
}
