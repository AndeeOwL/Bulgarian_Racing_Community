package com.andreanbuhchev.bulgarian_racing_community.web.rest;

import com.andreanbuhchev.bulgarian_racing_community.exceptions.ArticleNotFoundException;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.CommentCreationDto;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.CommentMessageDto;
import com.andreanbuhchev.bulgarian_racing_community.model.view.CommentDisplayView;
import com.andreanbuhchev.bulgarian_racing_community.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {
    private CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{articleId}/comments")
    public ResponseEntity<List<CommentDisplayView>> getComments(@PathVariable("articleId") Long articleId) {
        return ResponseEntity.ok(commentService.getAllCommentsForArticle(articleId));
    }

    @PostMapping(value = "/{articleId}/comments", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommentDisplayView> createComment(@PathVariable("articleId") Long articleId,
                                                           @AuthenticationPrincipal UserDetails userDetails,
                                                           @RequestBody CommentMessageDto commentDto) {
        CommentCreationDto commentCreationDto = new CommentCreationDto(
                userDetails.getUsername(),
                articleId,
                commentDto.getMessage()
        );

        CommentDisplayView comment = commentService.createComment(commentCreationDto);

        return ResponseEntity
                .created(URI.create(String.format("/api/%d/comments/%d", articleId, comment.getId())))
                .body(comment);
    }

    @ExceptionHandler({ArticleNotFoundException.class})
    public ResponseEntity<ErrorApiResponse> handleRouteNotFound() {
        return ResponseEntity.status(404).body(new ErrorApiResponse("Such article doesn't exist!", 1004));
    }
}



class ErrorApiResponse {
    private String message;
    private Integer errorCode;

    public ErrorApiResponse(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public ErrorApiResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
