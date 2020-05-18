package com.jf;

import com.jf.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTaskApplicationTests {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsync() {
        asyncService.hello();
        System.out.println("异步任务执行完成");
    }

}
