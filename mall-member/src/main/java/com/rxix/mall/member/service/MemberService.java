package com.rxix.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rxix.common.utils.PageUtils;
import com.rxix.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 19:01:54
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

