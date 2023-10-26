package com.step1;
//클래스를 두 개로 쪼개본다
class A1{
	int i = 1;
}

public class ASimulation1 {

	public static void main(String[] args) {
		A1 a = new A1();
		//insert here
		a.i =2;
		//내 안에서 A클래스에 정의된 전역변수를 호출하기
		int j = 0;
		//상수가 아니라 변수를 치환하면 j값도 따라서 바뀐다
		//상수 싫어요. 변수 좋아요
		//값이 변경되도록 하고 싶을 때 사용
		//변수 i가 1에서 2로 변경되었을 때 j값도 2가 되도록 하고 싶을때 사용
		j = a.i; //치환
		System.out.println(a.i); //2
		System.out.println(j); //2
	}

}
/*
ASimulation.java
A.class, ASimulation.class
(소스는 하나 클래스는 둘 생성)
*/