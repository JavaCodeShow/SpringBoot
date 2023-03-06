package com.jf.es.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.es.domain.Product;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 江峰
 * @date 2022/8/1 21:45
 */
@RestController
@Slf4j
public class ESIndexController {

    //注入 ElasticsearchRestTemplate
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    //创建索引并增加映射配置
    @GetMapping("/createIndex")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f52")
    public void createIndex() {
        //创建索引，系统初始化会自动创建索引
        System.out.println("创建索引");
    }

    @GetMapping("/deleteIndex")
    @MethodLogger(apiId = "6221f12e0a849a10a89f9f00")
    public CommonResult deleteIndex() {
        boolean flg = elasticsearchRestTemplate.deleteIndex(Product.class);
        System.out.println("删除索引 = " + flg);
        return CommonResult.success();
    }
}
