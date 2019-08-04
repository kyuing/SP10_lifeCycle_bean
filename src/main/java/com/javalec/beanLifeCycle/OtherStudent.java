package com.javalec.beanLifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {

	private String name;
	private int age;
	
	public OtherStudent(String name, int age) {
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
	
	/* annotation approach
	 * create a method(s) with the name you prefer. 
	 * if you want the method to do something in the initial step, just add @PostConstruct in front of the method
	 * if you want the method to do something in the destroying step, just add @PreDestroy in front of the method
	 */
	
	@PostConstruct
	public void initializeMethod() {
		System.out.println("initializeMethod(): annotation approach in OtherStudent class");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod(): annotation approach in OtherStudent class");
	}
}
