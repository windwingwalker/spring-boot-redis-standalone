package com.ek.template.redis.article;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    public ArticleService articleService;

    @GetMapping(produces = {"application/json"}) 
    public ResponseEntity<List<Article>> getArticles() { 
        List<Article> resBody= articleService.getArticles();
        return new ResponseEntity<List<Article>>(resBody, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"}) 
    public ResponseEntity<Article> getArticleById(@PathVariable("id") String id) {
        Article resBody = articleService.getArticleById(id);
        return new ResponseEntity<Article>(resBody, HttpStatus.OK);
    }

    @GetMapping(value = "/search/name/{name}", produces = {"application/json"}) 
    public ResponseEntity<Article> getArticleByName(@PathVariable("name") String name) {
        Article resBody = articleService.getArticleByTitle(name);
        return new ResponseEntity<Article>(resBody, HttpStatus.OK);
    }
    
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Article> addArticle(@RequestBody Article reqBody) { 
        Article resBody = articleService.addArticle(reqBody);
        return new ResponseEntity<Article>(resBody, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Article> updateArticle(@PathVariable("id") String id, @RequestBody Article reqBody) { 
        Article resBody = articleService.updateArticle(id, reqBody);
        return new ResponseEntity<Article>(resBody, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") String id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
