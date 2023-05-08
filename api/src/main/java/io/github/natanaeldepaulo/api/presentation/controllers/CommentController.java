package io.github.natanaeldepaulo.api.presentation.controllers;

import io.github.natanaeldepaulo.api.application.models.post.comment.ICommentService;
import io.github.natanaeldepaulo.api.application.models.post.comment.CommentRequest;
import io.github.natanaeldepaulo.api.application.models.post.comment.CommentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/post/{postId}/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> findById(@PathVariable String postId, @PathVariable String commentId){
        var response = commentService.findById(postId, commentId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<CommentDTO> createComment(@PathVariable String postId, @RequestParam String profileId, @RequestBody CommentRequest request){
        var response = commentService.create(request, postId, profileId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{commentId}")
    public  ResponseEntity<String> updateComment(@PathVariable String postId, @PathVariable String commentId, @RequestBody CommentRequest dataToUpdate){
        var response = commentService.updateCommentToPost(postId, commentId, dataToUpdate);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{commentId}")
    public  ResponseEntity<String> deleteComment(@PathVariable String postId, @PathVariable String commentId){
        var response = commentService.deleteCommentToPost(postId, commentId);
        return ResponseEntity.ok().body(response);
    }

}