package com.ek.template.redis.article;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Article")
public class Article {
    private String id;
    private String title;
}