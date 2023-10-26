package com.step2;

public class Method1 {
	//메소드 리턴타입에 void가 아닌 원시형 또는 참조형이 오면 
	//반드시 마지막(맨 끝)에 return 예약어를 쓴다.
	public String login(String id, String pw) {//( , )지역변수 -> 선언만 / 호출할 때 결정
		System.out.println("사용자가 입력한 id ==>" + id + " ,사용자가 입력한 비번은 ==>" + pw);
		//아래 9번을 변수로 바꿔보시오.
		String name = "나신입";
		return name;
		//int i = 1   //반드시 마지막엔 return으로 끝!
	}
	public int methodA() {
		return 12;
	}
	public double methodB() {
		return 1.2;
	}
	public boolean methodC() {
		return false;
	}
	public void methodD() {
		//난 return 예약어를 쓰지 않아도 괜찮아
	}
	public static void main(String[] args) {
		Method1 m = new Method1();
		String name = m.login("kiwi", "111"); //;으로 끝나면 메소드 호출
		System.out.println(name); //뭐가 출력될까? -> 나신입
		//파라미터 갯수는 2개지만 두번째 타입이 boolean이라서 에러
		//name = m.login("1",false);
		//아래 코드도 메소드의 파라미터가 2개가 필요한데 아무것도 안적었으니 에러
		//name = m.login();
		//선언된 메소드의 파라미터가 두개 인데 파라미터 값을 3개 적는 건 불법
		//name = m.login("","","");
	}

}
/*
 * 메소드 선언하기
 * 1. 리턴타입을 결정해주세요
 * 2. 파라미터가 필요한가요? 필요하다면 몇 개가 필요하지?
 * 3. 나만 사용할건지, 공유할건지 결정하자 - private, public
 * public > protected(서로 다른 패키지라 하더라도 서로 상속관계에 있으면 접근할 수 있다) > friendly(접근제한자가 아무것도 없다) > private
 * 
 * 메소드를 선언하는 문장
 * (접근제한자) 리턴타입(Void, 원시형타입, 참조형타입(주소번지)) 메소드이름(괄호는 빈상태, 한개, 두개 이상)
 */