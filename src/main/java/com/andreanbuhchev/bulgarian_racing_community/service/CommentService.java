package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.CommentDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface CommentService {

    void addComment(CommentDto addCommentModel, UserDetails userDetails, long id);

    void deleteComment(Long id, UserDetails userDetails);
}
