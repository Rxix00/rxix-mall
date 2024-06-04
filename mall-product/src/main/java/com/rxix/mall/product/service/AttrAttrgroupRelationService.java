package com.rxix.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rxix.common.utils.PageUtils;
import com.rxix.mall.product.entity.AttrAttrgroupRelationEntity;

import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 17:49:27
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

