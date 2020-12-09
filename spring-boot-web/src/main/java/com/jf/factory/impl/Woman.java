package com.jf.factory.impl;

import com.jf.factory.Person;
import com.jf.factory.PersonNameConstant;
import org.springframework.stereotype.Component;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-09 10:52:00
 * @since
 */
@Component(value = PersonNameConstant.WOMAN_NAME)
public class Woman implements Person {
    @Override
    public void say() {
        System.out.println("I am woman");
    }
}
