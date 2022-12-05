package com.jf.nacos.controller;

import com.jf.common.aspect.log.LogConstants;
import com.jf.common.utils.id.IdGenerator;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignInvokeInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        System.out.println(Thread.currentThread().getName());
        String traceId = MDC.get(LogConstants.TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            traceId = IdGenerator.getId();
        }
        template.header(LogConstants.TRACE_ID, traceId);
    }
}
