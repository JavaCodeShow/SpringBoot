package com.jf.es.controller;

import com.jf.es.dao.ProductDao;
import com.jf.es.domain.Product;
import com.jf.model.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
public class ESSearchController {

    @Autowired
    private ProductDao productDao;


    /**
     * term 查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构建器对象
     */
    @GetMapping("/termQuery")
    public BaseResult<List<Product>> termQuery() {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
        Iterable<Product> products = productDao.search(termQueryBuilder);
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            productList.add(product);
            System.out.println(product);
        }
        return BaseResult.success(productList);
    }

    /**
     * term 查询加分页
     */
    @GetMapping("/termQueryByPage")
    public BaseResult<List<Product>> termQueryByPage() {
        int currentPage = 0;
        int pageSize = 2;
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
        Iterable<Product> products =
                productDao.search(termQueryBuilder, pageRequest);
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            productList.add(product);
            System.out.println(product);
        }
        return BaseResult.success(productList);
    }
}
