package com.MusicCamp.backend.comment;


import com.MusicCamp.backend.comment.dto.CommentAllResDto;
import com.MusicCamp.backend.comment.dto.CommentCreateReqDto;
import com.MusicCamp.backend.comment.dto.CommentUpdateReqDto;
import com.MusicCamp.backend.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("comment/{commentId}")
    public BaseResponse<Void> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateReqDto commentUpdateReqDto){
        commentService.updateComment(commentId,commentUpdateReqDto);
        return BaseResponse.success();
    }

    @GetMapping("/comment/{postId}")
    public BaseResponse<List<CommentAllResDto>> getAllComment(@PathVariable Long postId){
        List<CommentAllResDto> commentAllResDtoList = commentService.getAll(postId);
        return BaseResponse.success(commentAllResDtoList);
    }
}
