package com.jf.service;

import com.jf.mapper.UserMapper;
import com.jf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   21:44
 */
@Service
public class UserService {

    // @Autowired
    // private RedisCacheManager redisCacheManager;

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user", /*condition = "#id>7",*/ unless = "#result==null")
    public User getUserById(Integer id) {
        System.out.println("查询" + id + "号用户");
        User user = userMapper.getUserById(id);
        return user;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @CachePut(value = "user", key = "#user.id")
    public User updateUser(User user) {
        System.out.println("cachePut更新缓存了:" + user.getId() + "号");
        userMapper.updateUser(user);
        return user;
    }

    @CacheEvict(value = "user",/*key = "#id",*/allEntries = true, beforeInvocation = true)
    public void deleteUser(Integer id) {
        System.out.println("删除了 " + id + " 号用户的缓存");
        //        userMapper.deleteUser(id);
    }
}
