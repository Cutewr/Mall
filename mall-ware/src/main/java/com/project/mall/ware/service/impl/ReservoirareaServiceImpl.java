package com.project.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.common.utils.PageUtils;
import com.project.common.utils.Query;

import com.project.mall.ware.dao.ReservoirareaDao;
import com.project.mall.ware.entity.ReservoirareaEntity;
import com.project.mall.ware.service.ReservoirareaService;


@Service("reservoirareaService")
public class ReservoirareaServiceImpl extends ServiceImpl<ReservoirareaDao, ReservoirareaEntity> implements ReservoirareaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReservoirareaEntity> page = this.page(
                new Query<ReservoirareaEntity>().getPage(params),
                new QueryWrapper<ReservoirareaEntity>()
        );

        return new PageUtils(page);
    }

}