package com.egg.news.service;

import com.egg.news.entity.News;
import com.egg.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public List<News> findAllNews() {
        List<News> newsList = new ArrayList();
        newsList = newsRepository.findAll();
        return newsList;
    }

    @Override
    public void deleteNewsById(Long id) {
        newsRepository.deleteById(id);

    }

    @Override
    public News findNewsById(Long id) {
        return newsRepository.findById(id).orElseThrow();
    }


}
