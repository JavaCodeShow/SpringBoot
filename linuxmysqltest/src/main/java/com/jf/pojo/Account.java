package com.jf.pojo;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04 15:26
 */
public class Account {
	private Integer id;
	private Double money;
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", money=" + money + ", age='" + age
				+ '\'' + '}';
	}
}
