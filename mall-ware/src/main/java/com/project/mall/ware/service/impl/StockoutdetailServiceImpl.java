package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.StockoutdetailDao;
import com.project.mall.ware.entity.StockoutdetailEntity;
import com.project.mall.ware.service.StockoutdetailService;


@Service("stockoutdetailService")
public class StockoutdetailServiceImpl extends ServiceImpl<StockoutdetailDao, StockoutdetailEntity> implements StockoutdetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockoutdetailEntity> page = this.page(
                new Query<StockoutdetailEntity>().getPage(params),
                new QueryWrapper<StockoutdetailEntity>()
        );

        return new PageUtils(page);
    }

}