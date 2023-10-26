package com.step2;

public class Method3 {
	public String login(String id, String pw) {
		String name = "나초보";
		return name;
	}
	public void methodD(String name) {
		System.out.println("methodD호출 성공: " +name);
	}
	public static void main(String[] args) {
		Method3 m = new Method3();		
		//methodD()는 리턴타입이 void라서 대입연산자를 통해 받을 수 없다.
		//int i = methodD();
		String name = m.login("apple", "123");
		//main안에서 선언한 지역변수 name의 값을 굳이 methodD에서 쓰고 싶어요. 어떡하지?
		m.methodD(name);
	}

}