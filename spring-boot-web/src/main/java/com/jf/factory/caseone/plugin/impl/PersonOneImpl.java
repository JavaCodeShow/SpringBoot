package com.jf.factory.caseone.plugin.impl;

import com.jf.factory.caseone.plugin.PersonPlugin;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2020-12-15 13:45
 * @since: 2.20.1
 */
@Component
public class PersonOneImpl implements PersonPlugin {
    @Override
    public Integer getKey() {
        return 1;
    }

    @Override
    public void say() {
        System.out.println("I am one");
    }
}
