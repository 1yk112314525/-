package com.example.Controller;

import com.example.Service.ServiceAdministrators;
import com.example.Service.ServiceUser;
import com.example.pojp.Article;
import com.example.pojp.Result;
import com.example.pojp.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Administrators {

    @Autowired
    ServiceUser serviceUser;
    @Autowired
    ServiceAdministrators serviceAdministrators;

    //用户注册
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        serviceUser.register(user);
        return Result.success();
    }

//    查询员工信息
    @GetMapping("/select")
    public Result getId(){
        List<User> allUser=serviceAdministrators.select();
        return Result.success(allUser);
    }

//   修改用户的信息
    //获取这个员工的信息
    @GetMapping("/update/{id}")
    public Result selectId(@PathVariable Integer id){
        User user=serviceAdministrators.selectId(id);
        return Result.success(user);
    }

    //修改用户信息
    @PutMapping("/update")
    public Result updateuser(@RequestBody User user){
        serviceAdministrators.updateUesr(user);
        return Result.success();
    }
    //删除员工信息
    @DeleteMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        serviceAdministrators.deleteuser(id);
        return Result.success();
    }

//    管理员查询栏目
    @GetMapping("/selectLabel")
    public Result selectLabel(){
        List<String> lambels=serviceAdministrators.selectLabel();
        return Result.success(lambels);
    }




//    管理员创建栏目
    @GetMapping("/addLabel/{label}")
    public Result label(@PathVariable String label){
        Article article=serviceAdministrators.semectlabel(label);
        if (article!=null){
            return Result.error("添加失败，栏目已存在");
        }
        serviceAdministrators.addLabel(label);
        return Result.success("添加成功！！");
    }

//    管理员删除用户
    @DeleteMapping("/delectLabel/{label}")
    public Result delectLabel(@PathVariable String label){
        serviceAdministrators.delectLabel(label);
        return Result.success("删除成功");
    }

//    管理员修改栏目
    @PutMapping("/setLabel")
    public Result setLabel(@RequestBody Article article){
        log.info("{}",article.getId());
        serviceAdministrators.setLabel(article.getId(),article.getLabel());
        return Result.success("修改成功!!");
    }

//    管理员修改文章
//    @PutMapping()
}
