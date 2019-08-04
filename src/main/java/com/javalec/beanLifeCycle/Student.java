package com.javalec.beanLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//interface approach
public class Student implements InitializingBean, DisposableBean {
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		//a specified constructor
		this.name = name;
		this.age = age;
	}
	
	//Since we are using the specified constructor, we only need getters
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	//initializing
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet(): interface approach in Student class");
	}
	
	@Override
	//destroying
	public void destroy() throws Exception {
		System.out.println("destroy(): interface approach in Student class");
	}
	
}
