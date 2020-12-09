package com.jf.factory.impl;

import com.jf.factory.Person;
import com.jf.factory.PersonNameConstant;
import org.springframework.stereotype.Component;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-09 10:50:51
 * @since
 */
@Component(value = PersonNameConstant.MAN_NAME)
public class Man implements Person {
    @Override
    public void say() {
        System.out.println("I am man");
    }
}
