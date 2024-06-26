package com.rxix.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rxix.mall.product.entity.AttrEntity;
import com.rxix.mall.product.entity.BrandEntity;
import com.rxix.mall.product.service.AttrService;
import com.rxix.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallProductApplicationTests {
    @Autowired
    AttrService attrService;

    @Autowired
    BrandService brandService;


    //TODO:测试问题：name显示乱码
    @Test
    void contextLoads() {
        BrandEntity entity = new BrandEntity();
        entity.setName("小米");
//        brandService.save(entity);
        AttrEntity attrEntity = new AttrEntity();
        attrEntity.setAttrName("华为");
        attrService.save(attrEntity);
        entity.setName("手机卡来得及");
        brandService.save(entity);
    }

    @Test
    void selectAll() {
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id",2));
        for (BrandEntity entity : list) {
            System.out.println(entity);
        }

        List<AttrEntity> attrList = attrService.list();
        for (AttrEntity entity : attrList) {
            System.out.println(entity);
        }
    }

}
