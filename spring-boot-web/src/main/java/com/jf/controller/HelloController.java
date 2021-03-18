package com.jf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.aspect.log.LogTypeEnum;
import com.jf.aspect.log.MethodLogger;
import com.jf.entity.Department;
import com.jf.entity.Employee;
import com.jf.exception.UserNotExitException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29 16:26
 */

@RestController
@Slf4j
public class HelloController {

	@Autowired
	private Department hello;

	@RequestMapping("/user/{username}")
	public String user(@PathVariable("username") String username) {
		if (!username.equals("tom")) {
			throw new UserNotExitException("user is not exit");
		}

		return "user是存在的";
	}

	@RequestMapping(value = { "/", "index.html" })
	public String index() {
		return "login";
	}

	@RequestMapping("/hello")
	@MethodLogger(logType = LogTypeEnum.RESPONSE)
	public String helloTest(String name) {

		return name;
	}

	@RequestMapping("/success")
	public String success(Map map) {
		int i = 1 / 0;
		map.put("hello", "你好啊");
		return "success";
	}

	@RequestMapping("/test")
	public void fun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/user/login").forward(request, response);
	}

	@RequestMapping("/abc")
	public Employee success(@RequestBody @Valid Employee employee) {

		return employee;
	}

	// 主线程获取子线程的返回值
	public static void main(String[] args)
			throws ExecutionException, InterruptedException {
		// ExecutorService es = Executors.newCachedThreadPool();
		// Future<Exception> submit = es.submit(() -> {
		// try {
		// int i = 1 / 0;
		// } catch (Exception e) {
		// return e;
		// }
		// return null;
		// });
		// Exception exception = submit.get();
		// if (exception != null) {
		// System.out.println("子线程发生了异常");
		// } else {
		// System.out.println("子线程没有发生异常");
		// }
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		List<CompletableFuture<Integer>> collect = list.stream()
				.map(e -> CompletableFuture.completedFuture(e).thenApply(x -> {
					System.out.println(x);
					return x * 2;
				})).collect(Collectors.toList());
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture
				.allOf(collect.toArray(new CompletableFuture[collect.size()]));
		// String result = CompletableFuture.supplyAsync(() -> {
		// System.out.println(Thread.currentThread().getName());
		// return "hello";
		// }).thenApplyAsync(v -> v + "world").join();
		// System.out.println(result);

	}
}
