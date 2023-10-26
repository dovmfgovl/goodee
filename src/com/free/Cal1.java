package com.free;

public class Cal1 {
	int plus(int a, int b) {
		int result = a + b;
		return result;
	}
		
	double avg(int a, int b) {
		double sum = plus(a, b);
		double result = sum/2;
		return result;
	}
	
	void excute() {
		double result = avg(8 , 15);
		println("실행결과: " + result);		
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		Cal1 c = new Cal1();
		c.excute();
	}
}
