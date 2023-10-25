package com.example.Service.impl;

import com.example.Mapper.UserMapper;
import com.example.pojp.Article;
import com.example.pojp.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ServiceAdministrators implements com.example.Service.ServiceAdministrators {

    @Autowired
    UserMapper userMapper;

//    用id查询
    @Override
    public User selectId(Integer id) {
        return userMapper.selectId(id);
    }
//  修改用户
    @Override
    public void updateUesr(User user) {
        log.error("经过这里{}",user);
        userMapper.updateUser(user);
    }

//    查询所有用户
    @Override
    public List<User> select() {

        return userMapper.select();
    }

    @Override
    public void deleteuser(Integer id) {
        userMapper.deleteUser(id);
    }

//    查询所有栏目
    @Override
    public List<String> selectLabel() {
        return userMapper.selectLambel();
    }

    @Override
    public void addLabel(String newLabel) {
        userMapper.addLabel(newLabel);
    }

    @Override
    public Article semectlabel(String label) {
        return userMapper.selectlabel(label);
    }

    @Override
    public void delectLabel(String label) {
        userMapper.delectLabel(label);
    }

    @Override
    public void setLabel(Integer id, String label) {
        userMapper.setLabel(id,label);
    }
}
