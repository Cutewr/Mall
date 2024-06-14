package com.project.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.common.utils.PageUtils;
import com.project.mall.ware.entity.StockinEntity;

import java.util.Map;

/**
 * 
 *
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-06-14 13:21:05
 */
public interface StockinService extends IService<StockinEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

