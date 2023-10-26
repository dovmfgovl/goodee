package com.step2;

public class Method2 {
	public String login(String id, String pw) {
		String name = "나신입";
		return name;
	}
	public int methodD() {
		return 0;
	}
	public static void main(String[] args) {
		Method2 m = new Method2();		
		//println메소드 호출할때 파라미터 자리에서 리턴타입이 있다면 호출할 수 있다.
		System.out.println(m.login("kiwi", "111"));
		//위와 반대되는 상황을 연출해보시오.
		System.out.println(m.methodD());
	}

}