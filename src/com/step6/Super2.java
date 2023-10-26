package com.step6;

public class Super2 extends Super1 {
	int b = 2;
	void methodB() {
		//내 안에 선언된 변수가 아니어도 부모가 가진 변수는 호출할 수 있다.
		System.out.println(a);
		System.out.println("methodB() 호출");
	}
	//Super2 클래스를 상속받는 클래스에서는 methodB와 methodC를 오버라이딩 할 수 있다.
	public void methodC() {
		System.out.println("Super2: methodC() 호출");
	}
}
