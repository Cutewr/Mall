package com.project.mall.coupon.dao;

import com.project.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-04-09 15:45:13
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
