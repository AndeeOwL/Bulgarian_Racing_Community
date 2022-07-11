package com.andreanbuhchev.bulgarian_racing_community.service.impl;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.ArticleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Article;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ArticleRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ArticleView;
import com.andreanbuhchev.bulgarian_racing_community.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ArticleServiceImpl implements ArticleService {


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ArticleRepository articleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
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
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }
}
