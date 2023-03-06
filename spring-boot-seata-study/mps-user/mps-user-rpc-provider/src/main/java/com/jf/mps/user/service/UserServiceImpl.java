package com.jf.mps.user.service;

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

    public UserEntity findById(String id) {
        UserEntity userEntity = userMapper.findById(id);
        return userEntity;
    }


}
