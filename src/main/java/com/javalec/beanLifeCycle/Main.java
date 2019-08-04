package com.javalec.beanLifeCycle;

import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) throws Exception {
		
		//spring bean life cycle
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	//create container
				
		ctx.load("classpath:applicationCTX.xml");	//set container

		/* once ctx is refreshed (initialized),  
		 * public void afterPropertiesSet() throws Exception {} is called in Student class: interface approach
		 * public void initializeMethod() {} is called in OtherStudent class: annotation approach
		 */
		ctx.refresh();	//refreshing; after using .load, you must use .refresh()
		
		Student student1 = ctx.getBean("xmlStudent", Student.class);
			System.out.println("\n" + "name: " + student1.getName());
			System.out.println("age: " + student1.getAge());
			//student1.destroy();	//if you want to destroy the bean only
		
		OtherStudent student2 = ctx.getBean("javaStudent", OtherStudent.class);	
			System.out.println("\n" + "name: " + student2.getName());
			System.out.println("age: " + student2.getAge());
			//student2.destroyMethod();	//if you want to destroy the bean only
			
			
		/* By using ctx.close(),
		 * public void destroy() throws Exception {} is called in Student class: interface approach
		 * public void destroyMethod() {} is called in OtherStudent class: annotation approach
		 */
		ctx.close();	//close the container (and bean)
		
		/* Note 
		 * ctx.close() is a step spring container is being destroyed
		 * once the container is destroyed, bean is automatically destroyed
		 * To destroy bean only, we can use API like; 
		 * ex) instanceNameGoesHere.destroy();
		 * ex) instanceNameGoesHere.destroyMethod();
		 */			
		
	}

}
