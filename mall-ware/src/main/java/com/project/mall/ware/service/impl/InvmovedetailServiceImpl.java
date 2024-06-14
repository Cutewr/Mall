package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.InvmovedetailDao;
import com.project.mall.ware.entity.InvmovedetailEntity;
import com.project.mall.ware.service.InvmovedetailService;


@Service("invmovedetailService")
public class InvmovedetailServiceImpl extends ServiceImpl<InvmovedetailDao, InvmovedetailEntity> implements InvmovedetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InvmovedetailEntity> page = this.page(
                new Query<InvmovedetailEntity>().getPage(params),
                new QueryWrapper<InvmovedetailEntity>()
        );

        return new PageUtils(page);
    }

}