package com.step1;

public class Static1 {
	//아래 변수 선언 3가지는 모두 원시형 타입이라서 변수를 호출하면 값이 출력됨
	//참조 변수는 호출하면 주소번지가 출력됨
	int i = 1;
	static int j = 2; //정적변수 - 클래스급 - 하나만 생성됨
	public double d = 0.5;
	public void methodA() {
		System.out.println("methodA호출 성공"); //꼭 한번은 직접 출력해보기 습관!
	}
	public static void methodB() {
		System.out.println("methodB호출 성공");
	}
	public static void main(String[] args) {
		Static1 s = new Static1();
		System.out.println(s.i); //1
		//변수 j선언시 static을 붙였으므로 인스턴스 변수 없이도 직접 호출이 가능함.
		System.out.println(j); //j는 인스턴스화 없이도 호출이 가능함 //2
		//insert here 0.5출력해 보시오.
		System.out.println(s.d);
		s.methodA();
		methodB();
	}

}
