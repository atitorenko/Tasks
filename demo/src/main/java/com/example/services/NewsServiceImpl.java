package com.example.services;

import com.example.entities.News;
import com.example.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksejtitorenko on 18.07.16.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findNews(Date start,Date end){
        return newsRepository.findNewsByDate(start, end);
    }
}
