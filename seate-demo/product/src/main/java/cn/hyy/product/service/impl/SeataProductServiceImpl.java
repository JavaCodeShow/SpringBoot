package cn.hyy.product.service.impl;

import cn.hyy.product.entity.SeataProduct;
import cn.hyy.product.mapper.SeataProductMapper;
import cn.hyy.product.service.SeataProductService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 产品服务类
 * @author: zyf
 * @date: 2022/01/24
 * @version: V1.0
 */
@Slf4j
@Service
public class SeataProductServiceImpl implements SeataProductService {

    @Resource
    private SeataProductMapper productMapper;

    /**
     * 事务传播特性设置为 REQUIRES_NEW 开启新的事务
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BigDecimal reduceStock(Long productId, Integer count) {
        log.info("=============PRODUCT START=================");
        System.out.println("seata全局事务id====================>" + RootContext.getXID());
        // 检查库存
        SeataProduct product = productMapper.selectByPrimaryKey(productId);
        Assert.notNull(product, "商品不存在");
        Integer stock = product.getStock();
        log.info("商品编号为 {} 的库存为{},订单商品数量为{}", productId, stock, count);
        product.setLastUpdateTime(new Date());
        if (stock < count) {
            log.warn("商品编号为{} 库存不足，当前库存:{}", productId, stock);
            throw new RuntimeException("库存不足");
        }
        log.info("开始扣减商品编号为 {} 库存,单价商品价格为{}", productId, product.getPrice());
        // 扣减库存
        int currentStock = stock - count;
        product.setStock(currentStock);
        productMapper.updateByPrimaryKey(product);
        BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(count));
        log.info("扣减商品编号为 {} 库存成功,扣减后库存为{}, {} 件商品总价为 {} ", productId, currentStock, count, totalPrice);
        log.info("=============PRODUCT END=================");
        return totalPrice;
    }
}