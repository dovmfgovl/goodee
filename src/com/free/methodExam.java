package com.free;

public class methodExam {
	
	public String login(String id, String pw) {
		String name = "김하나";
		return name;
	}
	
	public void methodA() {
		//return 예약어 사용X
	}

	public int methodB() {
		return 10;
	}
	
	public double methodC() {
		return 2.5;
	}
	
	public boolean methodD() {
		return true;
	}
	
	public static void main(String[] args) {
		methodExam value = new methodExam();
		String loginValue = value.login("gksk12", "1234");
		System.out.println(loginValue); //김하나
		System.out.println(value.methodB()); //10
		//methodA()는 리턴타입이 void라서 대입연산자를 통해 받을 수 없다
		//int A = methodA();
	}

}
