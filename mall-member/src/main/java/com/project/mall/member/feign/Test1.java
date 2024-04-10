package com.project.mall.member.feign;

import com.project.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-product")
public interface Test1 {

    @RequestMapping("product/brand/list")
    public R list();
}
