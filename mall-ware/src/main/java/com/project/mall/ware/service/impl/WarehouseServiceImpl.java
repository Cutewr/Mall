package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.WarehouseDao;
import com.project.mall.ware.entity.WarehouseEntity;
import com.project.mall.ware.service.WarehouseService;


@Service("warehouseService")
public class WarehouseServiceImpl extends ServiceImpl<WarehouseDao, WarehouseEntity> implements WarehouseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WarehouseEntity> page = this.page(
                new Query<WarehouseEntity>().getPage(params),
                new QueryWrapper<WarehouseEntity>()
        );

        return new PageUtils(page);
    }

}