package com.MusicCamp.backend.comment;

import com.MusicCamp.backend.comment.dto.CommentCreateReqDto;
import com.MusicCamp.backend.post.Post;
import com.MusicCamp.backend.post.PostRepository;
import com.MusicCamp.backend.user.User;
import com.MusicCamp.backend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
   private final CommentRepository commentRepository;
   private final PostRepository postRepository;
   private final UserRepository userRepository;
    public void createComment(Long postId, CommentCreateReqDto commentCreateReqDto) {
        Post post = postRepository.findById(postId).get();
        Long userId = commentCreateReqDto.getUserId();
        User user = userRepository.findById(userId).get();
        Comment comment = new Comment(user, post, commentCreateReqDto);
        commentRepository.save(comment);
    }
}
