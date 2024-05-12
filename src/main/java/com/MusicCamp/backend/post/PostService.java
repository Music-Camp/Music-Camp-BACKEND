package com.MusicCamp.backend.post;

import com.MusicCamp.backend.post.dto.PostDetailResDto;
import com.MusicCamp.backend.post.dto.PostCreateReqDto;
import com.MusicCamp.backend.post.dto.PostDetailResDto;
import com.MusicCamp.backend.post.dto.PostUpdateReqDto;
import com.MusicCamp.backend.user.User;
import com.MusicCamp.backend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updatePost(Long postId,PostUpdateReqDto postUpdateReqDto) {
        Post post = postRepository.findById(postId).get();
        post.modifyPost(postUpdateReqDto);
    }

    public List<PostDetailResDto> getAllPost() {
        List<Post> allPostList = postRepository.findAll();
        List<PostDetailResDto> PostDetailResDtosList = allPostList.stream().map((eachPost) -> PostDetailResDto.of(eachPost)).toList();
        return PostDetailResDtosList;
    }

    public PostDetailResDto getPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        PostDetailResDto postDetailResDto = PostDetailResDto.of(post);
        return postDetailResDto;
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
