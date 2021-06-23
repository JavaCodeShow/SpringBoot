package com.jf.template.domain.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-06-23 10:54
 * @since: 2.27
 */
// 有个很重要的点 UploadStaffTagExcelVoListener
// 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
@Data
public class UploadStaffTagExcelVoListener
		extends AnalysisEventListener<UploadStaffTagExcelVo> {

	/**
	 * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	 */
	List<UploadStaffTagExcelVo> list = new ArrayList<>();

	/**
	 * 这个每一条数据解析都会来调用
	 *
	 * @param data
	 *            one row value. Is is same as
	 *            {@link AnalysisContext#readRowHolder()}
	 * @param context
	 */
	@Override
	public void invoke(UploadStaffTagExcelVo data, AnalysisContext context) {
		log.info("解析到一条数据:{}", JSONObject.toJSONString(data));
		// 对数据进行校验
		validateData(data);
		String str = data.getCategoryIdStr().replaceAll("，", ",");
		String[] strArr = str.split(",");
		List<Integer> categoryIdList = Arrays.stream(strArr)
				.map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		data.setCategoryIdList(categoryIdList);
		list.add(data);
	}

	private void validateData(UploadStaffTagExcelVo data) {
		if (Objects.isNull(data.getJobNo()) || Objects.isNull(data.getOrgId())
				|| Objects.isNull(data.getCategoryIdStr())) {
			throw new IllegalArgumentException("格式不对");
		}
	}

	/**
	 * 所有数据解析完成了 都会来调用
	 *
	 * @param context
	 */
	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		log.info("所有数据解析完成！");
	}

}