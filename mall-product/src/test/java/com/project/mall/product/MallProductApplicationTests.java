package com.project.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.mall.product.entity.BrandEntity;
import com.project.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        brandId.forEach((item)->{
            System.out.println(item);
        });


    }

}
