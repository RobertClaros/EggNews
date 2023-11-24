package com.egg.news.service;
import com.egg.news.entity.News;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface INewsService {
    public News saveNews(News news);
    public List<News> findAllNews();
    public void deleteNewsById(Long id);
    public News findNewsById(Long id);



}
