package com.example.Mapper;

import com.example.pojp.Article;
import com.example.pojp.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapper {

    @Insert("insert into user(username,password,email,phone,name) value (#{username},#{password},#{email},#{phone},#{name})")
    void register(User user);

    User login(User user);

    @Update("update article set article=#{url} where id=#{id}")
    void updateArticle(Article article);
}
