package com.MusicCamp.backend.comment;


import com.MusicCamp.backend.comment.dto.CommentCreateReqDto;
import com.MusicCamp.backend.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{postId}")
    public BaseResponse<Void> createComment(@PathVariable Long postId, @RequestBody CommentCreateReqDto commentCreateReqDto){
        commentService.createComment(postId,commentCreateReqDto);
        return BaseResponse.success();
    }
}
