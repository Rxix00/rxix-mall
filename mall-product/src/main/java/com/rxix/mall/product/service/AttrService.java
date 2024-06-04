package com.rxix.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rxix.common.utils.PageUtils;
import com.rxix.mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 17:49:27
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

