package com.project.mall.order.dao;

import com.project.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-04-03 12:32:35
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
