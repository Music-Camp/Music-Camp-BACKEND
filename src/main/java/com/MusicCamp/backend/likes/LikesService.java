package com.MusicCamp.backend.likes;

import com.MusicCamp.backend.post.Post;
import com.MusicCamp.backend.post.PostRepository;
import com.MusicCamp.backend.user.User;
import com.MusicCamp.backend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LikesService {

    private final UserRepository userRepository;
    private final LikesRepository likesRepository;
    private final PostRepository postRepository;

    public void changeLikes(Long postId,Long userId) {

        User user = userRepository.findById(userId).get();
        // 사용자가 첫 좋아요여서 like id가 없는 경우 아래와 같이 Like 상태 값을 false를 디폴트로 생성함
        try{
            Likes likes = likesRepository.findByUser(user).get();
        }catch (Exception e){
            Post post = postRepository.findById(postId).get();
            Likes likes = new Likes(user, post, false);
            likesRepository.save(likes);
        }

        // 사용자의 값이 false인 경우 즉 좋아요가 안 눌려져 있어서 좋아요를 누르는 상황
        Likes likes = likesRepository.findByUser(user).get();
        if(likes.getIsStatus()==false){
            likes.setIsStatus(true);
            likesRepository.save(likes);
            // 사용자의 값이 true인 경우 즉 좋아요가 눌려져 있어서 좋아요를 취소하는 상황
        }else{
            likes.setIsStatus(false);
            likesRepository.save(likes);
        }



    }
}
