package com.tsolution.Student;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //생성
		ctx.load("classpath:applicationCTX4_Student2.xml"); //설정
		ctx.refresh();
		
		Student student1 = ctx.getBean("student", Student.class); //사용
		System.out.println("이름: " + student1.getName());
		System.out.println("나이: " + student1.getAge());

		Student student2 = ctx.getBean("student", Student.class); //사용
		student2.setName("홍길자");
		student2.setAge(46);
		System.out.println("이름: " + student1.getName());
		System.out.println("나이: " + student1.getAge());

		
		if(student1.equals(student2)) {
			System.out.println("student1==student2");
		}else {
			System.out.println("student1=!student2");
		}
		
		ctx.close();
	}
}
