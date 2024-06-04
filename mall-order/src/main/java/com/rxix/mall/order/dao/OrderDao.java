package com.rxix.mall.order.dao;

import com.rxix.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 18:54:06
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
