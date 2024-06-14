package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.MaterialDao;
import com.project.mall.ware.entity.MaterialEntity;
import com.project.mall.ware.service.MaterialService;


@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, MaterialEntity> implements MaterialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialEntity> page = this.page(
                new Query<MaterialEntity>().getPage(params),
                new QueryWrapper<MaterialEntity>()
        );

        return new PageUtils(page);
    }

}