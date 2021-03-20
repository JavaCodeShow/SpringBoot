package com.jf.css.service.impl;

import java.util.TreeSet;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.jf.css.listener.event.OrderSuccessEvent;
import com.jf.css.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@EventListener(OrderSuccessEvent.class)
	public void dispatch() {
		System.out.println("发车咯...");
	}

	public static void main(String[] args) {

	}

	public int[] fun(int min, int max, int n) {

		TreeSet<Integer> arrSet = new TreeSet<>();
		for (int i = 1; i <= n; i++) {
			arrSet.add(min * i + (n - i) * max);
		}
		return arrSet.stream().mapToInt(Integer::intValue).toArray();
	}
}
