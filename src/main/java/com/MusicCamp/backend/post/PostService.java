package com.MusicCamp.backend.post;

import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import com.MusicCamp.backend.user.User;
import com.MusicCamp.backend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    final private PostRepository postRepository;
    final private UserRepository userRepository;

    public void createPost(PostCreateReqDto postCreateReqDto){
        Long userId = postCreateReqDto.getUserId();
        User user = userRepository.findById(userId).get();
        Post post = new Post(user, postCreateReqDto);
        postRepository.save(post);
    }

}
