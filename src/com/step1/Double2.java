package com.step1;

public class Double2 {

	public static void main(String[] args) {
		int i = 1;
		//정수는 실수에 담을 수 있다.
		double d  = 2; //2.0
		i = (int)d; //2 - 여기서 괄호는 캐스팅 연산자라 부름 - 강제형전환
		System.out.println(i); //2
		System.out.println(d); //2.0
	}

}
