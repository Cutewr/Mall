package com.project.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.common.utils.PageUtils;
import com.project.mall.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author liufengrui
 * @email 222788360@gmail.com
 * @date 2024-04-03 12:01:48
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

