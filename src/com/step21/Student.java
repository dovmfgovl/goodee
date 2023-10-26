package com.step21;

public class Student {
	int html = 0;
	int css = 0;
	int java = 0;
	public static void main(String[] args) {
		Student s = new Student();
		s.html = 70;
		s.css = 80;
		s.java = 90;
		System.out.println(s);
		s = new Student(); //재정의 할때는 타입은 빼고 변수 이름만 사용해야함. Student s 로 타입을 쓰면 불법!
		s.html = 60;
		s.css = 70;
		s.java = 80;
		System.out.println(s);
		s = new Student();
		s.html = 50;
		s.css = 60;
		s.java = 70;
		System.out.println(s);
		//무엇을 보고 있나요? - 같은 타입의 클래스를 인스턴스화 할때마다 서로 다른 전역변수의 값을 관리할 수 있다.
		
		
		
		//for(1-초기화;2-조건식;3-증감연산자)
		//for문에서 조건식이 true이면 for문 안에 실행문이 차례대로 실행됨
//		int i;
//		for(i = 0; i < 3; i++) { //0 -> 1 -> 2 -> 3<3 -> false
//			Student s = new Student();
//			System.out.println(s);
		} //end of for
//		System.out.println(i);
	}
