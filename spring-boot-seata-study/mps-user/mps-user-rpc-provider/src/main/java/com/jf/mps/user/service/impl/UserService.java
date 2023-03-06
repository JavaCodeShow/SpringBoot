package com.jf.mps.user.service.impl;


import com.jf.mps.user.domain.entity.UserEntity;

/**
 * @author 江峰
 */
public interface UserService {

    UserEntity findById(String id);
}
