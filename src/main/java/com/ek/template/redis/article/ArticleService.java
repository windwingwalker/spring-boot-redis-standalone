package com.ek.template.redis.article;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ek.template.redis.exception.ResourceNotFoundException;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public Article addArticle(Article article){
        return articleRepository.save(article);
    }

    public List<Article> getArticles(){
        List<Article> res = new ArrayList<>();
        articleRepository.findAll().forEach(res::add);
        return res;
    }

    public Article getArticleById(String id){
        return articleRepository.findById(id)
            .orElseThrow(ResourceNotFoundException::new);
    }

    public Article getArticleByTitle(String name){
        return articleRepository.findByTitle(name)
            .orElseThrow(ResourceNotFoundException::new);
    }

    public Article updateArticle(String id, Article req){
        Article res = getArticleById(id);
        res.setTitle(req.getTitle());
        articleRepository.save(res);
        return res;
    }

    public void deleteArticle(String id){
        articleRepository.deleteById(id);
    }
    
}
