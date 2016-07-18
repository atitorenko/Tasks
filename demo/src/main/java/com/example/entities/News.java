package com.example.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksejtitorenko on 18.07.16.
 */
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")

    Date date;
}
