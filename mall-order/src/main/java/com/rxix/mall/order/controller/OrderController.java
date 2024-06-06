package com.rxix.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

import com.rxix.mall.order.fegin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.rxix.mall.order.entity.OrderEntity;
import com.rxix.mall.order.service.OrderService;
import com.rxix.common.utils.PageUtils;
import com.rxix.common.utils.R;


/**
 * 订单
 *
 * @author rxix
 * @email w937088290@gmail.com
 * @date 2024-06-04 18:54:06
 */
@RefreshScope
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public R queryProduct() {
        //OpenFeign 远程调用服务
        return R.ok().put("products", productService.queryAllBrand());
    }



    @Value("${user.userName}")
    private String userName;
    @Value("${user.age}")
    private Integer age;

    @GetMapping("/users")
    public R queryUser() {
        return R.ok().put("userName",userName).put("age",age);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrderEntity order) {
        orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OrderEntity order) {
        orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
