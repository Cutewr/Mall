package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.StoragerackDao;
import com.project.mall.ware.entity.StoragerackEntity;
import com.project.mall.ware.service.StoragerackService;


@Service("storagerackService")
public class StoragerackServiceImpl extends ServiceImpl<StoragerackDao, StoragerackEntity> implements StoragerackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StoragerackEntity> page = this.page(
                new Query<StoragerackEntity>().getPage(params),
                new QueryWrapper<StoragerackEntity>()
        );

        return new PageUtils(page);
    }

}