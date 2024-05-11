package com.MusicCamp.backend.likes;


import com.MusicCamp.backend.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class LikesController{

    private final LikesService likesService;
    @PostMapping("/likes/{postId}/{userId}")
    public BaseResponse<Void> changeLikes(@PathVariable Long postId,@PathVariable Long userId){
        likesService.changeLikes(postId,userId);
        return BaseResponse.success();
    }
}
