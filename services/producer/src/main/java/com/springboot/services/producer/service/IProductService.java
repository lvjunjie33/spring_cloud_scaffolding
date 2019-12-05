package com.springboot.services.producer.service;

import com.springboot.services.producer.entity.param.ProductQueryParam;
import com.springboot.services.producer.entity.po.Product;
import com.springboot.services.producer.hystrix.ProductHiHystric;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "service-client",fallback = ProductHiHystric.class)
public interface IProductService {
    /**
     * 获取用户
     *
     * @param id
     * @return
     */
	@RequestMapping(value = "/fein-test",method = RequestMethod.GET)
    String get(long id);

//    /**
//     * 新增用户
//     *
//     * @param product
//     * @return
//     */
//    long add(Product product);
//
//    /**
//     * 查询用户
//     *
//     * @return
//     */
//    List<Product> query(ProductQueryParam productQueryParam);
//
//    /**
//     * 更新用户信息
//     *
//     * @param product
//     */
//    @CacheEvict(value = "product", key = "#root.targetClass+'-'+#product.id")
//    void update(Product product);
//
//    /**
//     * 根据id删除用户
//     *
//     * @param id
//     */
//    @CacheEvict(value = "product", key = "#root.targetClass+'-'+#id")
//    void delete(long id);
}
