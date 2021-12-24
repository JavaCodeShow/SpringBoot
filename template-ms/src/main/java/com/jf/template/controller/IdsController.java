package com.jf.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.aspect.log.MethodLogger;
import com.jf.common.utils.result.BaseResult;
import com.jf.distribute.ids.proxy.IdsProxy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-03-27 15:03:35
 * @since
 */

@Api(value = "IdsController", tags = { "测试通过nacos获取分布式id" })
@RestController
public class IdsController {

	@Autowired
	private IdsProxy idsProxy;

	@ApiOperation("获取一个id")
	@GetMapping("/id")
	@MethodLogger
	public BaseResult<Long> getId() {
		Long id = idsProxy.getId();
		return BaseResult.success(id);
	}

	@ApiOperation("获取count个id")
	@GetMapping("/id/{count}")
	@MethodLogger
	public BaseResult<List<Long>> batchGetId(@PathVariable Integer count) {
		List<Long> ids = idsProxy.batchGetId(count);
		return BaseResult.success(ids);
	}

}
