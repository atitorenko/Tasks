package com.example.controllers;

import com.example.entities.News;
import com.example.services.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksejtitorenko on 18.07.16.
 */
@RestController
class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    List<News> getNews(@RequestParam(name = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                       @RequestParam(name = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        return newsService.findNews(start,end);
    }
}
