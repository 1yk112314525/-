package com.example.Controller;

import com.example.Service.ServiceUser;
import com.example.pojp.Article;
import com.example.pojp.Result;
import com.example.pojp.User;
import com.example.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    ServiceUser serviceUser;

//    用户登录
    //用户名和密码
    @PostMapping("/login1")
    public Result login1(@RequestBody User user){
        log.error("输入的信息为{}",user);
        User login= serviceUser.login(user);
        if(login!=null){
            return Result.success();
        }

        return Result.error();
    }
    //邮箱和密码
    @PostMapping("/login2")
    public Result login2(@RequestBody User user){
        log.error("输入的信息为{}",user);
        User login= serviceUser.login(user);
        if(login!=null){
            return Result.success();
        }

        return Result.error();
    }
    //手机号和密码
    @PostMapping("/login3")
    public Result login3(@RequestBody User user){
        log.error("输入的信息为{}",user);
        User login= serviceUser.login(user);
        if(login!=null){
            return Result.success();
        }

        return Result.error();
    }

    @Autowired
    AliOSSUtils aliOSSUtils;
//添加文章
    @PostMapping("/addArticle")
    public Result article(@RequestBody Article articles) {
        serviceUser.article(articles);
        return Result.success("文件上传成功！！");
    }

//查询该用户的所有文章
    @GetMapping("/allSelect/{id}")
    public Result allSelect(@PathVariable Integer id){
       List<Article> allSelect=serviceUser.allSelect(id);
       return Result.success(allSelect);
    }
//修改文章
//    1.拿到需要修改的文章
    @GetMapping("/selectArticle/{id}")
    public Result selectArticle(@PathVariable Integer id){
        Article article=serviceUser.selectArticle(id);
        return Result.success(article);
    }
//    2.修改返回来的文章
    @PostMapping("/updateArticle")
    public Result updateArticle(MultipartFile file ,Integer id,String columns) throws IOException {
        String url = aliOSSUtils.article(file);
        serviceUser.updateArticle(url,id,columns);
        return Result.success();
    }

//    用户通过author搜索文章
    @GetMapping("/authorSelect/{author}")
    public Result authorSelect(@PathVariable String author){
        List<Article> articles=serviceUser.authorSelect(author);
        return Result.success(articles);
    }

//    用户通过关键字搜索文章
    @GetMapping("/keywordsSelect/{keywords}")
    public Result keyordsSelect(@PathVariable String keywords){
        log.error("keywords为{}",keywords);
        List<Article> articles=serviceUser.keySelect(keywords);
        return Result.success(articles);
    }




}
