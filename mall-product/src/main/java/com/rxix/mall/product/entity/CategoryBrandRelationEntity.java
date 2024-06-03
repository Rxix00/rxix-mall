package com.rxix.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Æ·ÅÆ·ÖÀà¹ØÁª
 * 
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-03 22:08:10
 */
@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * Æ·ÅÆid
	 */
	private Long brandId;
	/**
	 * ·ÖÀàid
	 */
	private Long catelogId;
	/**
	 * 
	 */
	private String brandName;
	/**
	 * 
	 */
	private String catelogName;

}
