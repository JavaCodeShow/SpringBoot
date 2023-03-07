package com.jf.mps.user.service.impl;


import com.jf.mps.user.domain.entity.UserEntity;
import com.jf.mps.user.param.UpdateNameParam;

/**
 * @author 江峰
 */
public interface UserService {

    UserEntity findById(String id);

    void updateNameById(UpdateNameParam param);
}
