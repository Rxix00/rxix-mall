package com.rxix.mall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxix.common.utils.PageUtils;
import com.rxix.common.utils.Query;

import com.rxix.mall.product.dao.CategoryDao;
import com.rxix.mall.product.entity.CategoryEntity;
import com.rxix.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(new Query<CategoryEntity>().getPage(params), new QueryWrapper<CategoryEntity>());

        return new PageUtils(page);
    }

    /**
     * 查询所有的类别数据，然后将数据封装为树形结构使用
     *
     * @param params
     * @return
     */
    @Override
    public List<CategoryEntity> queryPageWithTree(Map<String, Object> params) {
        //1.查询所有的商品分类
        //查询所有的商品分类，所以条件为空
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        //2.将商品分类信息拆解为树形结构【父子关系】
        List<CategoryEntity> list = categoryEntities.stream().filter(categoryEntity -> (categoryEntity.getParentCid() != null && categoryEntity.getParentCid() == 0)).map(categoryEntity -> {
            //根据大类找到多有的小类，递归的方法实现
            categoryEntity.setChildren(getCategoryChildren(categoryEntity, categoryEntities));
            return categoryEntity;
        }).sorted((entity1, entity2) -> {
            return (entity1.getSort() == null ? 0 : entity1.getSort()) - (entity2.getSort() == null ? 0 : entity2.getSort());
        }).collect(Collectors.toList());
        return list;
    }

    /**
     * 逻辑批量删除操作
     *
     * @param ids
     */
    @Override
    public void removeCategoryByIds(List<Long> ids) {
        //TODO 1.检查类别数据是否在其他业务中使用

        //2.逻辑删除
        baseMapper.deleteBatchIds(ids);

    }

    /**
     * 查询该大类下的所有的小类  递归查找
     *
     * @param categoryEntity   某个大类
     * @param categoryEntities 所有的类别数据
     * @return
     */
    private List<CategoryEntity> getCategoryChildren(CategoryEntity categoryEntity, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> collect = categoryEntities.stream().filter(entity -> {
            //根据大类查找到他的直属的小类
            return entity.getParentCid().equals(categoryEntity.getCatId());
        }).map(entity -> {
            //根据这个小类递归找到对应的小小类
            entity.setChildren(getCategoryChildren(entity, categoryEntities));
            return entity;
        }).sorted((entity1, entity2) -> {
            return (entity1.getSort() == null ? 0 : entity1.getSort()) - (entity2.getSort() == null ? 0 : entity2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }
}