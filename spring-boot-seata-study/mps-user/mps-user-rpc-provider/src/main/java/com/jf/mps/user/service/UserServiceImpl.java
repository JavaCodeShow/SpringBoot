package com.jf.mps.user.service;

import com.alibaba.fastjson.JSONObject;
import com.jf.common.trace.core.LangHelper;
import com.jf.common.trace.utils.MdcUtils;
import com.jf.common.utils.id.IdGenerator;
import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import com.jf.mps.account.proxy.AccountProxy;
import com.jf.mps.user.domain.entity.UserEntity;
import com.jf.mps.user.mapper.UserMapper;
import com.jf.mps.user.param.UpdateNameParam;
import com.jf.mps.user.service.impl.UserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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
    private AccountProxy accountProxy;

    @Autowired
    @Qualifier("commonTaskExecutor")
    public TaskExecutor commonTaskExecutor;


    public UserEntity findById(String id) {
        UserEntity userEntity = userMapper.findById(id);
        commonTaskExecutor.execute(() -> {
            AccountInfo accountInfo = accountProxy.findById(id);
            log.info(MdcUtils.getOrGenTraceId());
            log.info("accountInfo={}", JSONObject.toJSONString(accountInfo));
        });

        log.info("userEntity={}", JSONObject.toJSONString(userEntity));
        log.info(MdcUtils.getOrGenTraceId());
        log.info(LangHelper.getLang());
        // System.out.println(accountInfo);
        return userEntity;
    }

    @Override
    @Transactional
    @GlobalTransactional
    public void updateNameById(UpdateNameParam param) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        userMapper.updateNameById(param.getId(), param.getName());
        AccountCreateOrUpdateParam createOrUpdateParam = new AccountCreateOrUpdateParam();
        createOrUpdateParam.setId(IdGenerator.getId());
        createOrUpdateParam.setUserId(IdGenerator.getId());
        createOrUpdateParam.setMoney(new BigDecimal(111));
        accountProxy.createOrUpdate(createOrUpdateParam);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                // 事务提交后需要执行的业务逻辑: 发消息, 日志...
                System.out.println("事务提交了");
            }
        });
        int i = 1 / 0;
    }

}
