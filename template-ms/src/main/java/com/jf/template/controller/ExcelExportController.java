package com.jf.template.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.jf.template.utils.easyexcel.ExcelExportUtils;
import com.jf.template.utils.easyexcel.LocalDateTimeConverter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * excel文件导出
 * 
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-04-17 14:19:39
 * @since
 */
@RestController
@Slf4j
public class ExcelExportController {

	/**
	 * 直接导出
	 *
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/excel/export1")
	public void exportExcel(HttpServletResponse response) throws IOException {

		String fileName = "测试导出";
		OutputStream outputStream = ExcelExportUtils.getOutputStream(response,
				fileName, ExcelTypeEnum.XLSX);

		ExcelWriter excelWriter = null;
		try {
			excelWriter = EasyExcel.write(outputStream, DemoData.class).build();
			WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
			for (int i = 0; i < 2; i++) {
				excelWriter.write(data(), writeSheet);
			}

		} finally {
			// 千万别忘记finish 会帮忙关闭流
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}

	}

	/**
	 * 先生成excel，再写入到respoonse流里面去。
	 *
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/excel/export2")
	public void exportExcel2(HttpServletResponse response) throws IOException {
		String bashPath = "C:\\Users\\Administrator\\Desktop\\";
		String fileName = "测试导出.xlsx";
		String filePath = bashPath + fileName;

		ExcelWriter excelWriter = null;
		try {
			// 这里 需要指定写用哪个class去写
			excelWriter = EasyExcel.write(filePath, DemoData.class).build();
			// 这里注意 如果同一个sheet只要创建一次
			WriteSheet writeSheet = EasyExcel.writerSheet("export2模板").build();
			// 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
			for (int i = 0; i < 5; i++) {
				// 分页去数据库查询数据 这里可以去数据库查询每一页的数据
				List<DemoData> data = data();
				excelWriter.write(data, writeSheet);
			}
		} finally {
			// 千万别忘记finish 会帮忙关闭流
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}

		// 将生成的文件写入到流里面去
		ExcelExportUtils.writeFileToResponse(response, fileName, filePath);

	}

	/**
	 * 10条数据
	 *
	 * @return
	 */
	private List<DemoData> data() {
		List<DemoData> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			DemoData data = new DemoData();
			data.setString("字符串" + i);
			data.setDate(LocalDateTime.now());
			data.setDoubleData(0.56);
			list.add(data);
		}
		return list;
	}

}

@Data
class DemoData {
	@ExcelProperty("字符串标题")
	private String string;

	@ExcelProperty(value = "日期标题", converter = LocalDateTimeConverter.class)
	private LocalDateTime date;

	@ExcelProperty("数字标题")
	private Double doubleData;

	/**
	 * 忽略这个字段
	 */
	@ExcelIgnore
	private String ignore;
}