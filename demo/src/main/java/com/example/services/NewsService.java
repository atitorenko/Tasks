package com.example.services;

import com.example.entities.News;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksejtitorenko on 18.07.16.
 */
public interface NewsService {
    List<News> findNews(Date start, Date end);
}
