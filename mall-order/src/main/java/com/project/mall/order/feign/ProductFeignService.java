package com.project.mall.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("mall-product")
public interface ProductFeignService {
}
