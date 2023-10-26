package com.week1;

public class MethodCall {
	void methodA() {	
		System.out.println("methodA");
	}
	void methodB() {
		System.out.println("methodB");
		//mehtodB 안에서 methodA()를 호출하는 것도 합법이다.
		methodA();
	}
	public static void main(String[] args) {
		MethodCall mc = new MethodCall();
		mc.methodB();
		//methodA만 호출하면 A만 출력되지만, methodB를 호출하면 B,A 둘 다 호출된다.
	}

}