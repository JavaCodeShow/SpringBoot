package com.jf.factory.caseone.plugin.impl;

import com.jf.factory.caseone.plugin.PersonPlugin;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2020-12-15 13:48
 * @since: 2.20.1
 */
@Component
public class PersonTwoImpl implements PersonPlugin {
    @Override
    public Integer getKey() {
        return 2;
    }

    @Override
    public void say() {
        System.out.println("I am two");
    }
}
