package io.github.natanaeldepaulo.api.application.implementation;

import io.github.natanaeldepaulo.api.application.ICommentService;
import io.github.natanaeldepaulo.api.application.IPostService;
import io.github.natanaeldepaulo.api.application.specification.CommentRequest;
import io.github.natanaeldepaulo.api.application.specification.CommentResponse;
import io.github.natanaeldepaulo.api.application.utils.ConvertFormatId;
import io.github.natanaeldepaulo.api.domain.embedded.Comment;
import io.github.natanaeldepaulo.api.domain.interfaces.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private IPostRepository postRepository;

    @Autowired
    IPostService postService;

    @Override
    public CommentResponse create(CommentRequest request, String postId, String profileId){
        var comment = Comment.create(
                request.description,
                ConvertFormatId.toUUID(postId) ,
                ConvertFormatId.toUUID(profileId)
        );

        postService.saveCommentToList(comment, comment.getPost_id().toString());
        return new CommentResponse(comment);
    }
}
