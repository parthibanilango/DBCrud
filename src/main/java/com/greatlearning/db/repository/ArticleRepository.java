package com.greatlearning.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.db.model.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Long>{

}