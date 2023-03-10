package cn.hyy.product.mapper;

import cn.hyy.product.entity.SeataProduct;
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
public interface SeataProductMapper {

    @Select("<script>  " +
            "   select * from product where id = #{id}" +
            " </script> ")
    SeataProduct selectByPrimaryKey(@Param("id") Long id);

    @Update("<script>  " +
            " update product" +
            "    set price = #{po.price}," +
            "      stock = #{po.stock}," +
            "      last_update_time = #{po.lastUpdateTime}" +
            "    where id = #{po.id}" +
            " </script> ")
    Integer updateByPrimaryKey(@Param("po") SeataProduct po);
}