package com.example.Service;

import com.example.pojp.Article;
import com.example.pojp.User;

import java.util.List;

public interface ServiceAdministrators {

    public User selectId(Integer id);

    void updateUesr(User user);

    List<User> select();

    void deleteuser(Integer id);

    List<String> selectLabel();

    void addLabel(String newLabel);

    Article semectlabel(String label);

    void delectLabel(String label);

    void setLabel(Integer id, String label);
}
