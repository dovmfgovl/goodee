package com.step2;

public class String1 {

	public static void main(String[] args) {
		String s1 = new String("키위");
		System.out.println(s1);
		//같은 이름의 변수(s1)이더라도 new를 사용해서 인스턴스화를 한 번 더 하면 새로운 객체가 만들어지는 것. 
		s1 = new String("키위");
		System.out.println(s1);
	}

}
/*
 String타입은 클래스지만 마치 원시형 타입처럼 값이 출력됨.
 주소번지를 볼 수 없음.
 */