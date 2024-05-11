package com.MusicCamp.backend.comment;


import com.MusicCamp.backend.comment.dto.CommentAllResDto;
import com.MusicCamp.backend.comment.dto.CommentCreateReqDto;
import com.MusicCamp.backend.comment.dto.CommentUpdateReqDto;
import com.MusicCamp.backend.config.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
@Tag(name = "CommentController",
        description = "게시판 내 댓글 관련 기능을 담당합니다. path : localhost:8080/music/comment로 시작합니다.")
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

    @DeleteMapping("comment/{commentId}")
    public BaseResponse<Void> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return BaseResponse.success();
    }
}
