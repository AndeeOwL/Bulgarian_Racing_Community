package com.andreanbuhchev.bulgarian_racing_community.model.repository;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

}
