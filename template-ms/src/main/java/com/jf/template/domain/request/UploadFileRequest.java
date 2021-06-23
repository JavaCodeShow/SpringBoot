package com.jf.template.domain.request;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-06-22 16:37
 * @since: 2.27
 */

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 发送文件请求体
 *
 * @author feng.jiang@marketin.cn
 * @create 2020-01-21 11:18
 * @since 2.27
 */
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileRequest {

	@ApiModelProperty("文件")
	private MultipartFile file;
}
