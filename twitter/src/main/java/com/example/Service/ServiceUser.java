package com.example.Service;

import com.example.pojp.Article;
import com.example.pojp.User;

import java.util.List;

public interface ServiceUser {
    void register(User user);

    User login(User user);

    void article(Article article);

    Article selectArticle(Integer id);

    List<Article> allSelect(Integer id);


    void updateArticle(String url, Integer id,String column);

    List<Article> authorSelect(String author);

    List<Article> keySelect(String keywords);
}
