package com.jf.repository;

import com.jf.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   18:43
 */
// 继承CrudRepository来完成对数据库的操作
public interface UserRepository extends CrudRepository<User,Integer> {

}
