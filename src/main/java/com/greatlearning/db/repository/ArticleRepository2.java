package com.greatlearning.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.db.model.Article;

@Repository
public interface ArticleRepository2 extends PagingAndSortingRepository<Article, Long>{

	Article findByTitle(String title);
	
}