package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.InventorymoveDao;
import com.project.mall.ware.entity.InventorymoveEntity;
import com.project.mall.ware.service.InventorymoveService;


@Service("inventorymoveService")
public class InventorymoveServiceImpl extends ServiceImpl<InventorymoveDao, InventorymoveEntity> implements InventorymoveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InventorymoveEntity> page = this.page(
                new Query<InventorymoveEntity>().getPage(params),
                new QueryWrapper<InventorymoveEntity>()
        );

        return new PageUtils(page);
    }

}