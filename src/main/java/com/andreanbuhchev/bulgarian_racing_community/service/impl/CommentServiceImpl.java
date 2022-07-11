package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.CommentDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Article;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Comment;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ArticleRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.CommentRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public void addComment(CommentDto addCommentModel, UserDetails userDetails, long id) {
        Comment newComment = new Comment();

        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).
                orElseThrow();

        Article article = articleRepository.findById(id).orElseThrow();

        modelMapper.map(addCommentModel,newComment);
        newComment.setUserEntity(user);
        newComment.setArticle(article);
        article.getComments().add(newComment);



        commentRepository.save(newComment);

    }

    @Override
    public void deleteComment(Long id, UserDetails userDetails) {

        commentRepository.deleteById(id);

    }
}
