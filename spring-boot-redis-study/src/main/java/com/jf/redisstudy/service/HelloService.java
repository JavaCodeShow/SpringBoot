package com.jf.redisstudy.service;

import com.jf.redisstudy.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class HelloService {

    List<UserDTO> list = new ArrayList<>();

    public void hello() {

        log.info("开始创建对象了。" + Thread.currentThread().getName());
        for (int i = 0; i < 10000000; i++) {
            list.add(UserDTO.getUserOne());
        }
        System.out.println(list.size());
        System.out.println(list.get(0));
        log.info("开始睡觉了。" + Thread.currentThread().getName());

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("睡觉结束了");
    }

}
