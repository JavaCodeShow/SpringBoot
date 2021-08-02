package com.jf.mybatis;

import com.jf.mybatis.mapper.AccountMapper;
import com.jf.mybatis.mapper.ClassesMapper;
import com.jf.mybatis.pojo.Account;
import com.jf.mybatis.pojo.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private AccountMapper accountMapper;

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

    /**
     * 根据钱或姓名查找账户
     */
    @Test
    public void test03() {
        Account account = new Account();
        // account.setName("张三");
        // account.setMoney(100);
        List<Account> accountList = accountMapper.getAccountByMoneyAndName(account);
        for (Account a : accountList) {
            System.out.println(a);
        }
    }

    /**
     * 根据多个money查找账户
     */
    @Test
    public void test04() {
        Account account = new Account();
        // account.setName("张三");
        // account.setMoney(100);
        int[] moneys = {99, 100};
        List<Account> accountList = accountMapper.getAccountByMoneys(moneys);
        for (Account a : accountList) {
            System.out.println(a);
        }
    }
}
