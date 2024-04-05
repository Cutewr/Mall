package com.project.mall.member.dao;

import com.project.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author liufengrui
 * @email 222788360@gmail.com
 * @date 2024-04-03 12:01:48
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
