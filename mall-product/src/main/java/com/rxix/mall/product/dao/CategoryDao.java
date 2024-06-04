package com.rxix.mall.product.dao;

import com.rxix.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 17:49:27
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
