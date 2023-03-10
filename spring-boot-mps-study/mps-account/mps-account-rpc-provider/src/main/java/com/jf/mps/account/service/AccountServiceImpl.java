package com.jf.mps.account.service;

import com.jf.mps.account.domain.entity.AccountEntity;
import com.jf.mps.account.info.AccountInfo;
import com.jf.mps.account.mapper.AccountMapper;
import com.jf.mps.account.param.AccountCreateOrUpdateParam;
import com.jf.mps.account.service.impl.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author 江峰
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public AccountInfo findById(String id) {
        AccountEntity entity = accountMapper.findById(id);
        AccountInfo info = new AccountInfo();
        if (Objects.nonNull(entity)) {
            BeanUtils.copyProperties(entity, info);
        }
        return info;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public String createOrUpdate(AccountCreateOrUpdateParam param) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        accountMapper.insert(param);
        // // TransactionSynchronizationAdapter是TransactionSynchronization的默认实现
        // TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
        //     @Override
        //     public void afterCommit() {
        //         // 事务提交后需要执行的业务逻辑: 发消息, 日志...
        //         System.out.println("事务提交了");
        //     }
        // });
        return param.getId();
    }


}
