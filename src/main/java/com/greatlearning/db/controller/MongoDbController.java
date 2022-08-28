package com.greatlearning.db.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.db.model.Article;
import com.greatlearning.db.repository.ArticleRepository;
import com.greatlearning.db.repository.ArticleRepository2;
import com.greatlearning.db.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class MongoDbController {
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private ArticleRepository2 articleRepository2;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @PostMapping("/articles/get")
    public ResponseEntity <Article> getArticleById( @RequestBody Article articleDetails)
    throws Exception {
    	Article article = articleRepository2.findByTitle(articleDetails.getTitle());
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/articles")
    public Article createArticle(@Validated @RequestBody Article article) {
        return articleRepository.save(article);
    }

    @PutMapping("/articles/put")
    public ResponseEntity < Article > updateArticle(@RequestBody Article articleDetails) throws Exception {
    	Article article = articleRepository2.findByTitle(articleDetails.getTitle());
       	if(null != articleDetails.getTitle()) {
       		article.setTitle(articleDetails.getTitle());
       	}
       	if(null != articleDetails.getKeywords()) {
       		article.setKeywords(articleDetails.getKeywords());
       	}
    	if(null != articleDetails.getFileName()) {
    		article.setFileName(articleDetails.getFileName());
    	}
    	if(null != articleDetails.getAuthor()) {
    		article.setAuthor(articleDetails.getAuthor());
    	}
        final Article updatedArticle = articleRepository.save(article);
        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("/articles/delete")
    public Map<String, Boolean> deleteArticle(@RequestBody Article articleDetails) throws Exception
     {
    	Article article  = articleRepository2.findByTitle(articleDetails.getTitle());
    	
    	articleRepository.delete(article);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}