package com.jf.mps.user.service;

import com.alibaba.fastjson.JSONObject;
import com.jf.common.utils.id.IdGenerator;
import com.jf.model.request.GenericRequest;
import com.jf.model.request.IdRequest;
import com.jf.mps.account.client.AccountClient;
import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import com.jf.mps.user.domain.entity.UserEntity;
import com.jf.mps.user.mapper.UserMapper;
import com.jf.mps.user.param.UpdateNameParam;
import com.jf.mps.user.service.impl.UserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author 江峰
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private AccountClient accountClient;

    public UserEntity findById(String id) {
        UserEntity userEntity = userMapper.findById(id);
        AccountInfo accountInfo = accountClient.findById(new IdRequest(id)).getData();
        log.info("userEntity={}", JSONObject.toJSONString(userEntity));
        log.info("accountInfo={}", JSONObject.toJSONString(accountInfo));
        System.out.println(accountInfo);
        return userEntity;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @GlobalTransactional(rollbackFor = Exception.class)
    public void updateNameById(UpdateNameParam param) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        // userMapper.updateNameById(param.getId(), param.getName());
        AccountCreateOrUpdateParam createOrUpdateParam = new AccountCreateOrUpdateParam();
        createOrUpdateParam.setId(IdGenerator.getId());
        createOrUpdateParam.setUserId(IdGenerator.getId());
        createOrUpdateParam.setMoney(new BigDecimal(111));
        accountClient.createOrUpdate(new GenericRequest<>(createOrUpdateParam));
        int i = 1 / 0;
    }

}
