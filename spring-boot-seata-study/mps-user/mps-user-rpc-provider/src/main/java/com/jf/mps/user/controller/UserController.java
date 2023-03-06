package com.jf.mps.user.controller;

import com.jf.common.aspect.log.MethodLogger;
import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.user.api.UserApi;
import com.jf.mps.user.domain.entity.UserEntity;
import com.jf.mps.user.info.UserInfo;
import com.jf.mps.user.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @MethodLogger(apiId = "6221deeb0a849a5acc9cb183")
    public CommonResult<UserInfo> findById(IdRequest request) {
        log.info("还不错啊");
        UserEntity userEntity = userService.findById(request.getId());
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(userEntity, info);
        return CommonResult.success(info);
    }


}