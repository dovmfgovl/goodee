package com.week1;

public class Print1 {
	static int m() {return 5;}
	static void n() {}
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println("안녕");
		System.out.println(1.5);
		System.out.println(true);		
		//메소드의 파라미터 자리에서 또 다른 메소드를 호출할 수도 있다.
		//단, 리턴타입이 void인 건 아니다. 안된다
		System.out.println(Print1.m());	 // 5
		System.out.println("===========");		
		//System.out.println(Print1.n());	 // 에러. return문 없는 void 리턴타입이니까
	}

}
