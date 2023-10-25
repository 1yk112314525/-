package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alios.oss")
public class AliOSSProperties {

//    存储终端地址
    private String endpoint;
//    登录凭证，即账户密码
    private String accessKeyId;
    private String accessKeySecret;
//    存储位置
    private String bucketName;

}
