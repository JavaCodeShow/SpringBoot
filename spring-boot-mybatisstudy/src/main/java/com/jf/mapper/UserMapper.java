package com.jf.mapper;

import com.jf.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 江峰
 * @create 2019-09-29   10:37
 */
// 使用mapperscan扫描所有接口，便无需@Mapper注解了
@Mapper
public interface UserMapper {
    /**
     * 查询所有人
     *
     * @return
     */
    @Select("select * from user")
    List<User> getAllUser();

    /**
     * gen据id查询人
     *
     * @param id
     * @return
     */
    // @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into user (name,password) values (#{name},#{password})")
    void addUser(User user);
}
