package com.jf.template.utils.easyexcel;

import java.io.*;
import java.net.URLEncoder;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.support.ExcelTypeEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-04-17 17:08:31
 * @since
 */
@Slf4j
public class ExcelExportUtils {

	/**
	 * 得到流
	 *
	 * @param response
	 *            响应
	 * @param fileName
	 *            文件名
	 * @param excelTypeEnum
	 *            excel类型
	 * @return
	 */
	public static OutputStream getOutputStream(HttpServletResponse response,
			String fileName, ExcelTypeEnum excelTypeEnum) {
		try {
			// 设置响应输出的头类型
			if (Objects.equals(".xls", excelTypeEnum.getValue())) {
				// 导出xls格式
				response.setContentType(
						"application/vnd.ms-excel;charset=UTF-8");
			} else if (Objects.equals(".xlsx", excelTypeEnum.getValue())) {
				// 导出xlsx格式
				response.setContentType(
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
			}

			fileName = URLEncoder.encode(fileName, "UTF-8");
			response.setHeader("Content-disposition",
					"attachment;filename*=utf-8''" + fileName
							+ excelTypeEnum.getValue());
			response.setCharacterEncoding("utf8");
			return response.getOutputStream();
		} catch (IOException e) {
			log.error("EasyExcelUtil-->getOutputStream exception:", e);
		}
		return null;
	}

	/**
	 * 将文件写入到流里面去
	 * 
	 * @param response
	 * @param fileName
	 * @param filePath
	 */
	public static void writeFileToResponse(HttpServletResponse response,
			String fileName, String filePath) {

		response.setContentType("application/vnd.ms-excel; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			File file = new File(filePath);
			InputStream stream = new FileInputStream(file);
			ServletOutputStream out = response.getOutputStream();
			byte buff[] = new byte[1024];
			int length = 0;

			while ((length = stream.read(buff)) > 0) {
				out.write(buff, 0, length);
			}
			stream.close();
			out.close();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
