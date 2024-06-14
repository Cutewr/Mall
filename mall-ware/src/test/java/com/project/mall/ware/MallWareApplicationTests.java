package com.project.mall.ware;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class MallWareApplicationTests {

    @Test
    void contextLoads() throws IOException {
        // 创建OkHttpClient实例
        OkHttpClient client = new OkHttpClient();

        // 设置请求体的媒体类型为application/json
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

        // 'input' 指的是 JSON Payload
        String input = "grant_type=client_credentials&client_id=hust12&client_secret=n=d.z,p3W%J_qD*";

        // 创建请求体
        RequestBody body = RequestBody.create(mediaType, input);

        // 创建POST请求
        Request request = new Request.Builder()
                .url("https://apis-sandbox.fedex.com/oauth/token")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        // 发送请求并获取响应
        Response response = client.newCall(request).execute();

        // 输出响应结果
        System.out.println(response.body().string());
    }

}
