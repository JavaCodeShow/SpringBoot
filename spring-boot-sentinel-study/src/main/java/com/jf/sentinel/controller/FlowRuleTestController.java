package com.jf.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.jf.common.utils.time.LocalDateTimeUtil;
import com.jf.model.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class FlowRuleTestController {

    @GetMapping("/create_order")
    public CommonResult hello() {
        Entry entry = null;
        // 务必保证finally会被执行
        try {
            // 资源名可使用任意有业务语义的字符串
            entry = SphU.entry("create_order");
            // 被保护的业务逻辑
            System.out.println("create order success  + " + LocalDateTimeUtil.getLocalDateTimeStr());
            return CommonResult.success("create order success");
        } catch (BlockException e1) {
            // 资源访问阻止，被限流或被降级
            // 进行相应的处理操作
            System.out.println("创建订单限流了");
            return CommonResult.fail("创建订单限流了");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    /**
     * 定义限流规则
     * <p>
     * 此注解的含义是：本类构造方法执行结束后执行
     */
    @PostConstruct
    public void init() {
        // 1.创建存放限流规则的集合
        List<FlowRule> rules = new ArrayList<>();
        // 2.创建限流规则
        FlowRule rule = new FlowRule();
        // 定义资源，表示Sentinel会对哪个资源生效
        rule.setResource("create_order");
        // 定义限流的类型(此处使用QPS作为限流类型)
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 定义QPS每秒通过的请求数
        rule.setCount(1);
        // 3.将限流规则存放到集合中
        rules.add(rule);
        // 4.加载限流规则
        FlowRuleManager.loadRules(rules);
    }
}
