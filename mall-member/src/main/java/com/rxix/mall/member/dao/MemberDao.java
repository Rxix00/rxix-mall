package com.rxix.mall.member.dao;

import com.rxix.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 19:01:54
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
