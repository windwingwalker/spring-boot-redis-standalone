package com.ek.template.redis.article;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String> {
    Optional<Article> findByTitle(String title);
}
