package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.ArticleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Article;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ArticleView;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void addArticle(ArticleDto articleDto, UserDetails userDetails);

    void deleteArticle(Long id);

    List<Article> findAllArticles();
}
