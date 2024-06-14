package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.StockoutDao;
import com.project.mall.ware.entity.StockoutEntity;
import com.project.mall.ware.service.StockoutService;


@Service("stockoutService")
public class StockoutServiceImpl extends ServiceImpl<StockoutDao, StockoutEntity> implements StockoutService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockoutEntity> page = this.page(
                new Query<StockoutEntity>().getPage(params),
                new QueryWrapper<StockoutEntity>()
        );

        return new PageUtils(page);
    }

}