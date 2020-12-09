package com.jf.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂模式
 *
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-09 10:53:32
 * @since
 */
@Component
public class PersonFactory {

    private static final Map<Integer, Person> map = new HashMap<>();

    @Autowired
    private Map<String, Person> personMap;

    @PostConstruct
    public void init() {
        map.put(1,
                personMap.get(PersonNameConstant.MAN_NAME));
        map.put(2,
                personMap.get(PersonNameConstant.WOMAN_NAME));
    }

    public static Person match(Integer target) {
        return map.get(target);
    }

}
