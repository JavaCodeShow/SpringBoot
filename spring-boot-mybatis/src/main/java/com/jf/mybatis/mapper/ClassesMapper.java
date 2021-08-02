package com.jf.mybatis.mapper;

import com.jf.mybatis.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 江峰
 * @create 2019-12-27 15:55
 */
@Mapper
public interface ClassesMapper {
    List<Classes> listClasses(int i);

    List<Classes> listClasses2(int i);
}
