package io.github.natanaeldepaulo.api.application;

import io.github.natanaeldepaulo.api.application.specification.CommentRequest;
import io.github.natanaeldepaulo.api.application.specification.CommentResponse;

import java.util.Optional;

public interface ICommentService {
    CommentResponse create(CommentRequest request, String postId, String profileId);
}
