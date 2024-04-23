package com.jf.es.controller;

import com.jf.es.dao.ProductDao;
import com.jf.es.domain.Product;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 江峰
 * @date 2022/8/1 21:52
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductDao productDao;

    /**
     * 新增文档
     */
    @GetMapping("/save")
    public CommonResult<Boolean> save() {
        //POSTMAN, GET http://172.31.128.22:9200/product/_doc/2
        Product product = new Product();
        product.setId(2L);
        product.setTitle("华为手机");
        product.setCategory("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.atguigu/hw.jpg");
        productDao.save(product);
        return CommonResult.success(Boolean.TRUE);
    }

    /**
     * 修改文档
     */
    @GetMapping("/update")
    public CommonResult<Boolean> update() {
        //POSTMAN, GET http://172.31.128.22:9200/product/_doc/2
        Product product = new Product();
        product.setId(2L);
        product.setTitle("小米 2 手机");
        product.setCategory("手机");
        product.setPrice(9999.0);
        product.setImages("http://www.atguigu/xm.jpg");
        productDao.save(product);
        return CommonResult.success(Boolean.TRUE);

    }


    /**
     * 根据id查询文档
     */
    @GetMapping("/findById")
    public CommonResult<Product> findById() {
        Product product = productDao.findById(2L).get();
        System.out.println(product);
        return CommonResult.success(product);
    }

    /**
     * 查询所有文档
     */
    @GetMapping("/findAll")
    public CommonResult<List<Product>> findAll() {
        Iterable<Product> products = productDao.findAll();
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            productList.add(product);
            System.out.println(product);
        }

        return CommonResult.success(productList);
    }

    /**
     * 删除文档
     */
    @GetMapping("/delete")
    public CommonResult delete() {
        //POSTMAN, GET http://172.31.128.22:9200/product/_doc/2
        Product product = new Product();
        product.setId(2L);
        productDao.delete(product);
        return CommonResult.success(Boolean.TRUE);

    }

    /**
     * 批量新增文档
     */
    @GetMapping("/saveAll")
    public CommonResult saveAll() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setTitle("[" + i + "]小米手机");
            product.setCategory("手机");
            product.setPrice(1999.0 + i);
            product.setImages("http://www.atguigu/xm.jpg");
            productList.add(product);
        }
        productDao.saveAll(productList);
        return CommonResult.success(Boolean.TRUE);

    }

    /**
     * 分页查询
     */
    @GetMapping("/findByPageable")
    public CommonResult<Page<Product>> findByPageable() {
        //设置排序(排序方式，正序还是倒序，排序的 id)
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        int currentPage = 0;//当前页，第一页从 0 开始， 1 表示第二页
        int pageSize = 2;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        //分页查询
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product Product : productPage.getContent()) {
            System.out.println(Product);
        }
        return CommonResult.success(productPage);
    }
}
