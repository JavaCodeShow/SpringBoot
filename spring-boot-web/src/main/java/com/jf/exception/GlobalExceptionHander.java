package com.jf.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * 处理全局异常
 *
 * @author 江峰
 * @date 2020/6/29 16:28
 */

@ControllerAdvice
@Component
@RestController
@Slf4j
public class GlobalExceptionHander {

	@ExceptionHandler(value = Exception.class)
	public String hello(Exception e) {
		System.out.println(e.getMessage());
		return e.getMessage();
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handle(ValidationException exception) {
		if (exception instanceof ConstraintViolationException) {
			ConstraintViolationException exs = (ConstraintViolationException) exception;

			Set<ConstraintViolation<?>> violations = exs
					.getConstraintViolations();
			for (ConstraintViolation<?> item : violations) {
				// 打印验证不通过的信息
				System.out.println(item.getMessage());
			}
		}
		return exception.getMessage();
	}

	@GetMapping("/validate1")
	@ResponseBody
	public String validate1(
			@Size(min = 1, max = 10, message = "姓名长度必须为1到10") @RequestParam("name") String name,
			@Min(value = 10, message = "年龄最小为10") @Max(value = 100, message = "年龄最大为100") @RequestParam("age") Integer age) {
		return "validate1";
	}
}
