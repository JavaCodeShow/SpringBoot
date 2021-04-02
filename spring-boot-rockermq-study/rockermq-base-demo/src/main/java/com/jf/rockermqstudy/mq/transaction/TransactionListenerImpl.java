package com.jf.rockermqstudy.mq.transaction;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import com.jf.common.utils.utils.time.LocalDateTimeUtil;

/**
 * @author 江峰
 * @date 2020/8/18 17:09
 */
public class TransactionListenerImpl implements TransactionListener {
	private final AtomicInteger transactionIndex = new AtomicInteger(0);
	private final AtomicInteger checkTimes = new AtomicInteger(0);
	private final ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

	/**
	 * 本地事务的执行逻辑
	 *
	 * @param msg
	 * @param arg
	 * @return
	 */
	@Override
	public LocalTransactionState executeLocalTransaction(Message msg,
			Object arg) {

		LocalTransactionState state;

		System.out.println("执行本地事务");
		if (StringUtils.equals("msg-4", msg.getKeys())) {
			state = LocalTransactionState.COMMIT_MESSAGE;
		} else if (StringUtils.equals("msg-5", msg.getKeys())) {
			state = LocalTransactionState.ROLLBACK_MESSAGE;
		} else {
			state = LocalTransactionState.UNKNOW;
			localTrans.put(msg.getKeys(), transactionIndex.incrementAndGet());
		}
		System.out.println("executeLocalTransaction: " + msg.getKeys()
				+ ",excute state: " + state + ",current time: "
				+ LocalDateTimeUtil.getLocalDateTimeStr());
		return state;
	}

	/**
	 * 回查本地事务的代码实现
	 *
	 * @param msg
	 * @return
	 */
	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
		System.out.println("checkLocalTransaction message key: " + msg.getKeys()
				+ ",current time: " + LocalDateTimeUtil.getLocalDateTimeStr());
		Integer index = localTrans.get(msg.getKeys());

		if (null != index) {
			switch (index) {
				case 1:
					System.out.println("check result: unknow, 回查次数："
							+ checkTimes.incrementAndGet());
					return LocalTransactionState.UNKNOW;
				case 2:
					System.out.println("check result: commit message");
					return LocalTransactionState.COMMIT_MESSAGE;
				case 3:
					System.out.println("check result: rollback message");
					return LocalTransactionState.ROLLBACK_MESSAGE;
			}
		}
		return LocalTransactionState.COMMIT_MESSAGE;
	}
}