package com.example.utils;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOSSUtils {

    @Autowired
    AliOSSProperties aliOSSProperties;

//实现文章上传到阿里云OSS对象存储服务器
    public String article(MultipartFile file) throws IOException {
        String endpoint=aliOSSProperties.getEndpoint();
        String accessKeySecret=aliOSSProperties.getAccessKeySecret();
        String accessKeyId=aliOSSProperties.getAccessKeyId();
        String bucketName=aliOSSProperties.getBucketName();
        //获取上传文件的输入流
        InputStream inputStream=file.getInputStream();

        //避免文件重复
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回

    }
}
