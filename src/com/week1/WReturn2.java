package com.week1;

public class WReturn2 {
	int i; // 전역변수 i이다
	void methodA() {
		int i = 2; // 지역변수
		System.out.println(i);
	}
	int methodB() {
		int i = 1; // 지역변수 i이다
		return i; // 1
	}

	public static void main(String[] args) {
		WReturn2 wr = new WReturn2();		
		System.out.println(wr.methodB());
		//System.out.println(wr.methodA()); //에러. void라 리턴문이 없으니까 리턴값이 없어서 다른 메소드에서 재사용할 수 없다.
		wr.methodA(); // 2
		System.out.println( wr.i); // 0 (전역변수 출력)
	}

}
