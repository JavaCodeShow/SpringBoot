package com.jf.config;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author 潇潇暮雨
 * @create 2019-09-10   22:46
 */
@Component
@Import(MyImportSelector.class)
public class ImportClass {

}
