package com.jf.mybatis;

import com.jf.mybatis.mapper.ClassesMapper;
import com.jf.mybatis.pojo.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * Description: 测试班级与老师一对一关联关系
     *
     * @param
     * @return void
     * @author JourWon
     * @date 2019/9/24 23:18
     */
    @Test
    public void test01() {
        List<Classes> classes = classesMapper.listClasses(1);
        for (Classes aClass : classes) {
            System.out.println(classes);
        }
    }

    /**
     * Description: 测试班级与学生一对多关联关系
     *
     * @param
     * @return void
     * @author JourWon
     * @date 2019/9/24 23:19
     */
    @Test
    public void test02() {
        List<Classes> classes = classesMapper.listClasses2(1);
        for (Classes aClass : classes) {
            System.out.println(classes);
        }
    }
}
