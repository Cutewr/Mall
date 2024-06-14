package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.StockinDao;
import com.project.mall.ware.entity.StockinEntity;
import com.project.mall.ware.service.StockinService;


@Service("stockinService")
public class StockinServiceImpl extends ServiceImpl<StockinDao, StockinEntity> implements StockinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockinEntity> page = this.page(
                new Query<StockinEntity>().getPage(params),
                new QueryWrapper<StockinEntity>()
        );

        return new PageUtils(page);
    }

}