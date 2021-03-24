package com.jf.css.factory.casetwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 策略工厂模式
 *
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-09 10:53:32
 * @since
 */
@Component
public class PersonFactory {

	private static final Map<Integer, Person> map = new HashMap<>();

	@Autowired
	private List<Person> personList;

	@PostConstruct
	public void init() {
		personList.forEach(person -> map.put(person.getKey(), person));
	}

	public static Person match(Integer key) {
		return map.get(key);
	}

}
