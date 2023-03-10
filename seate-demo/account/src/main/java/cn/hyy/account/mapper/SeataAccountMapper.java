package cn.hyy.account.mapper;

import cn.hyy.account.entity.SeataAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @Description: TODO
 * @author: zyf
 * @date: 2022/01/24
 * @version: V1.0
 */
@Mapper
public interface SeataAccountMapper {

    @Select("<script>  " +
            "   select * from account where id = #{id}" +
            " </script> ")
    SeataAccount selectByPrimaryKey(@Param("id") Long id);

    @Update("<script>  " +
            " update account" +
            "    set balance = #{po.balance}," +
            "      last_update_time = #{po.lastUpdateTime}" +
            "    where id = #{po.id}" +
            " </script> ")
    Integer updateByPrimaryKey(@Param("po") SeataAccount po);
}