package com.jf.mps.user.service;

import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.proxy.AccountProxy;
import com.jf.mps.user.domain.entity.UserEntity;
import com.jf.mps.user.mapper.UserMapper;
import com.jf.mps.user.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 江峰
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountProxy accountProxy;

    public UserEntity findById(String id) {
        UserEntity userEntity = userMapper.findById(id);
        AccountInfo accountInfo = accountProxy.findById(id);
        System.out.println(userEntity);
        System.out.println(accountInfo);
        return userEntity;
    }

}
