package com.step3;

import java.util.Random;

public class Return1 {
	void m() {
		System.out.println("리턴타입 자리에 void인 경우 = 반환값을 받을 수 없다.");
	}
	int m2() {
		System.out.println("리턴타입 자리에 XXX인 경우 = 반환값을 받을 수 있다.");
		return 0;
	}
	String m3() {
		System.out.println("리턴타입 자리에 XXX인 경우 = 반환값을 받을 수 있다.");
		return "높여라";
	}
	Random m4() {
		return new Random();
	}
	Random m5() {
		Random r = new Random();
		return r;
	}
	public static void main(String[] args) {
		Return1 r1 = new Return1();
		//int i = r1.m();
		//System.out.println(r1.m());
		int i = r1.m2();
		System.out.println(r1.m2()); //0이 출력된다.
		System.out.println(r1.m3()); //높여라
		//m4와 m5메소드의 리턴타입은 오브젝트이다
		//그러니까 뒤에 메소드를 호출할 수 있다.
		System.out.println(r1.m4().nextInt(10));
		System.out.println(r1.m5().nextInt(5));
	}

}
