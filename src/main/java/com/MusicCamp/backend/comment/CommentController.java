package com.MusicCamp.backend.comment;


import com.MusicCamp.backend.comment.dto.CommentCreateReqDto;
import com.MusicCamp.backend.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class CommentController {

    private final CommentService commentService;
    public BaseResponse<Void> createComment(@PathVariable Long postId, @RequestBody CommentCreateReqDto commentCreateReqDto){
        commentService.createComment(postId,commentCreateReqDto);
        return BaseResponse.success();
    }
}
