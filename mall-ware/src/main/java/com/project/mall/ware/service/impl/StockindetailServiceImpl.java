package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.StockindetailDao;
import com.project.mall.ware.entity.StockindetailEntity;
import com.project.mall.ware.service.StockindetailService;


@Service("stockindetailService")
public class StockindetailServiceImpl extends ServiceImpl<StockindetailDao, StockindetailEntity> implements StockindetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockindetailEntity> page = this.page(
                new Query<StockindetailEntity>().getPage(params),
                new QueryWrapper<StockindetailEntity>()
        );

        return new PageUtils(page);
    }

}