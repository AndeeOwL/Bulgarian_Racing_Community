package com.andreanbuhchev.bulgarian_racing_community.service.impl;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.ArticleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Article;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ArticleRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.CommentRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ArticleView;
import com.andreanbuhchev.bulgarian_racing_community.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void addArticle(ArticleDto articleDto, UserDetails userDetails) {

        Article newArticle = new Article();

        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).
                orElseThrow();

        modelMapper.map(articleDto,newArticle);
        newArticle.setUserEntity(user);



        articleRepository.save(newArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleView> findAllArticles() {

        List<Article> articles = articleRepository.findAll();
        List<ArticleView> articleViews = new ArrayList<>();

        articles.forEach(a -> {
            ArticleView articleView = new ArticleView();
            modelMapper.map(a,articleView);
            articleView.setAuthor(a.getUserEntity().fullName());
            articleViews.add(articleView);
        });
        return articleViews;
    }
}
