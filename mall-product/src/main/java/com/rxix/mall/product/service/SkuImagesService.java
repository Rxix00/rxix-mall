package com.rxix.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rxix.common.utils.PageUtils;
import com.rxix.mall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 17:49:27
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

