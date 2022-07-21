package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.exceptions.ArticleNotFoundException;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.CommentCreationDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Article;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Comment;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ArticleRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.CommentRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.view.CommentDisplayView;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    public CommentService(ArticleRepository articleRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public List<CommentDisplayView> getAllCommentsForArticle(Long articleId) {

        Article article = articleRepository.findById(articleId).orElseThrow(ArticleNotFoundException::new);

        List<Comment> comments = commentRepository.findAllByArticle(article).get();
        return comments.stream().map(comment -> new CommentDisplayView(comment.getId(), comment.getAuthor().fullName(),
            comment.getText())).collect(Collectors.toList());
    }

    public CommentDisplayView createComment(CommentCreationDto commentDto) {
        UserEntity author = userRepository.findByUsername(commentDto.getUsername()).get();

        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setArticle(articleRepository.getById(commentDto.getArticleId()));
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setText(commentDto.getMessage());

        commentRepository.save(comment);

        return new CommentDisplayView(comment.getId(), author.fullName(), comment.getText());
    }
}
