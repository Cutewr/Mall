package com.project.mall.product;
import okhttp3.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.mall.product.entity.BrandEntity;
import com.project.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        //BrandEntity brandEntity = new BrandEntity();
        //brandEntity.setName("荣耀");
        //brandService.save(brandEntity);
        //System.out.println("success");

        List<BrandEntity> brandId = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 9L));
        brandId.forEach((item) -> {
            System.out.println(item);
        });
    }



    @Test
    public void authorization() throws IOException {
        // 创建OkHttpClient实例
        OkHttpClient client = new OkHttpClient();

        // 设置请求体的媒体类型为application/json
        MediaType mediaType = MediaType.parse("application/json");

        // 'input' 指的是 JSON Payload
        String input = "{\"grant_type\":\"client_credentials\",\"client_id\":\"740561073\",\"client_secret\":\"l7063bef08439d4bb8b5a4971b8e74c7cc\"}";

        // 创建请求体
        RequestBody body = RequestBody.create(mediaType, input);

        // 创建POST请求
        Request request = new Request.Builder()
                .url("https://apis-sandbox.fedex.com")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        // 发送请求并获取响应
        Response response = client.newCall(request).execute();
        // 输出响应结果
        System.out.println(response);
        System.out.println(response.body().string());
    }


}
