package com.jf.redisstudy.distributedLock;

/**
 * @author 江峰
 * @create 2020-03-30   16:42
 */
public interface DistributedLock {
    /**
     * 获取锁
     * @author zhi.li
     * @return 锁标识
     */
    String acquire();

    /**
     * 释放锁
     * @author zhi.li
     * @param indentifier
     * @return
     */
    boolean release(String indentifier);
}
