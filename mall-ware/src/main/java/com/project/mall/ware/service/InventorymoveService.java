package com.project.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.common.utils.PageUtils;
import com.project.mall.ware.entity.InventorymoveEntity;

import java.util.Map;

/**
 * 
 *
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-06-14 13:21:04
 */
public interface InventorymoveService extends IService<InventorymoveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

