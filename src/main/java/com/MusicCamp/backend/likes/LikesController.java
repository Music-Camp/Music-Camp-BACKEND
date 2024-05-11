package com.MusicCamp.backend.likes;


import com.MusicCamp.backend.config.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
@Tag(name = "LikesController",
        description = "좋아요 관련 기능을 담당합니다. path : localhost:8080/music/likse로 시작합니다.")
public class LikesController{

    private final LikesService likesService;
    @PostMapping("/likes/{postId}/{userId}")
    public BaseResponse<Void> changeLikes(@PathVariable Long postId,@PathVariable Long userId){
        likesService.changeLikes(postId,userId);
        return BaseResponse.success();
    }
}
