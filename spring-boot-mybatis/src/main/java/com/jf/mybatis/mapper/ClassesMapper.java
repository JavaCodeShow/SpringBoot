package com.jf.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jf.mybatis.pojo.Classes;

/**
 * @author 江峰
 * @create 2019-12-27 15:55
 */
@Mapper
public interface ClassesMapper {
	List<Classes> listClasses(int i);

	List<Classes> listClasses2(int i);
}
