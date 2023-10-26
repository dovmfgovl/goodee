package com.step1;
//클래스를 두 개로 쪼개본다
class A{
	int i = 1;
}

public class ASimulation {

	public static void main(String[] args) {
		A a = new A();
		//내 안에서 A클래스에 정의된 전역변수를 호출하기
		int j = 0;
		j = a.i; //치환
		System.out.println(a.i); //1
		System.out.println(j); //1
	}

}
/*
ASimulation.java
A.class, ASimulation.class
(소스는 하나 클래스는 둘 생성)
*/