package com.example.Service.impl;

import com.example.Mapper.LoginMapper;
import com.example.Mapper.UserMapper;
import com.example.pojp.Article;
import com.example.pojp.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class ServiceUser implements com.example.Service.ServiceUser {

    @Autowired
    LoginMapper loginMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void register(User user) {
        loginMapper.register(user);
    }

    @Override
    public User login(User user) {

        return loginMapper.login(user);
    }


    @Override
    public void article(Article article)
    {
        article.setCreatTime(LocalDateTime.now());
        userMapper.article(article);
    }

    @Override
    public Article selectArticle(Integer id) {
        return userMapper.selectArticle(id);

    }

    @Override
    public List<Article> allSelect(Integer id) {
        List<Article> articles = userMapper.allSelect(id);
        return articles;
    }

    @Override
    public void updateArticle(String url, Integer id,String column) {
        userMapper.updateArticle(url,id,column);
    }

    @Override
    public List<Article> authorSelect(String author) {
        return userMapper.authorSelect(author);
    }

    @Override
    public List<Article> keySelect(String keywords) {
        return userMapper.keySelect(keywords);
    }
}
