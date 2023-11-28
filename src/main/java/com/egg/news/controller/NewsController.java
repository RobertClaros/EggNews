package com.egg.news.controller;


import com.egg.news.DTO.NewsRequestDTO;
import com.egg.news.entity.News;
import com.egg.news.service.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("egg-news")
@CrossOrigin(value="http://localhost:5173")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    private INewsService newsService;

    @GetMapping("/news")
    public List<News> newsList() {
        var news = newsService.findAllNews();
        news.forEach((news1 -> logger.info(news1.toString())));
        return news;
    }

    @PostMapping("/news")
    public News saveNews(@RequestBody NewsRequestDTO newsRequestDTO) {
        News news = new News();
        String title = newsRequestDTO.getTitle();
        news.setTitle(title);
        news.setContent(newsRequestDTO.getContent());
        news.setImageUrl(newsRequestDTO.getImageUrl());

        return newsService.saveNews(news);
    }
    @GetMapping("/news/{id}")
    public ResponseEntity<News> findNewsById(@PathVariable Long id) {
        News news = newsService.findNewsById(id);
        return ResponseEntity.ok(news);
    }

    @PutMapping("/news/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News incomingNews){
        News news = newsService.findNewsById(id);
        news.setTitle(incomingNews.getTitle());
        news.setContent(incomingNews.getContent());
        news.setImageUrl(incomingNews.getImageUrl());
        newsService.saveNews(news);
        return ResponseEntity.ok(news);
    }


    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNewsById(id);
    }
}
