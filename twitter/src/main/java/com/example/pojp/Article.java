package com.example.pojp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id; //文章id
    private Integer userId;  //用户id
    private String label;  //栏目
    private String article;  //文章
    private String title;  //标题
    private String author;  //作者
    private LocalDateTime creatTime;  //创建时间
}
