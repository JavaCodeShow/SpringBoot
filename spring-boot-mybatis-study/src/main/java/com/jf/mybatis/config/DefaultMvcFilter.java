package com.jf.mybatis.config;


import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class DefaultMvcFilter implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //   对FastJsonConfig进行配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 修改全局json配置
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        // 格式化时间
        serializeConfig.put(Date.class, new OwnSimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        serializeConfig.put(java.sql.Date.class, new OwnSimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        serializeConfig.put(java.sql.Timestamp.class, new OwnSimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        serializeConfig.put(java.sql.Time.class, new OwnSimpleDateFormatSerializer("HH:mm:ss"));
        serializeConfig.put(LocalDateTime.class, new OwnSimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializeConfig(serializeConfig);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.IgnoreErrorGetter,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect
        );
    }
}