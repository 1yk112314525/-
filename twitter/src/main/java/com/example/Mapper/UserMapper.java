package com.example.Mapper;

import com.example.pojp.Article;
import com.example.pojp.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

//    查询所有用户
    @Select("select * from user")
    List<User> select();

//    通过id返回用户信息
    @Select("select * from user where id=#{id}")
    User selectId(Integer id);

//    修改用户信息
    void updateUser(User user);

//    删除用户信息
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

//    添加文章
    @Insert("insert into articles(user_id,label, article,title,author, creat_time) value (#{userId},#{label},#{article},#{title},#{author},#{creatTime})")
    void article(Article article);


//    查询返回该用户所有文章
    @Select("select * from articles where user_id=#{id} ")
    Article selectArticle(Integer id);

//    查询该用户
    @Select("select * from articles where user_id=#{id}")
    List<Article> allSelect(Integer id);
//    修改用户
    @Update("update articles set article=#{url},columns=#{column} where id=#{id}")
    void updateArticle(String url, Integer id,String column);

//    查询作者名下文章
    @Select("select * from articles where author=#{author}")
    List<Article> authorSelect(String author);

//    关键字查询
    @Select("select * from articles where article like concat('%',#{keywords},'%')")
    List<Article> keySelect(String keywords);

//    查询所有栏目
    @Select("select label from articles")
    List<String> selectLambel();
    @Select("select * from articles where label=#{label}")
    Article selectlabel(String label);

    @Insert("insert into articles(label) value (#{newlabel})")
    void addLabel(String newLabel);

    @Delete("delete from articles where label=#{label}")
    void delectLabel(String label);

    @Update("update articles set label=#{label} where id=#{id}")
    void setLabel(Integer id, String label);
}
