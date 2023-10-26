package com.week1;
//<메소드 선언 문장> (접근제한자 - 생략가능) 리턴타입 메소드이름(파라미터 자리)
//메소드 선언 시 리턴타입이 오는 자리에 void가 있다면 return예약어 쓸 수 없다.
//리턴되는 값이 없다면 다른 메소드에서 그 메소드가 가진 데이터를 재사용할 수 없다.
public class WReturn1 {
	void methodA() {
		
	}
	//리턴 다음에 오는 코드는 반드시 타입을 맞춰야 함
	//하나만 반환할 수 있다.
	//만약 여러 개의 값을 반환하고 싶다면 참조형 타입을 사용하면 된다.(1-3)
	int methodB() {
		return (int)1.5; // 1
	}

	public static void main(String[] args) {
		//여기에서 methodB의 반환값을 출력할 수 있다.
		WReturn1 wr = new WReturn1();
		//리턴타입이 void가 아닌 것은 대입연산자를 써서 반환되는 값을 담을 수 있다.
		int i = wr.methodB();		
		//여기에서 methodA의 반환값을 출력할 수 없다.
		//i = wr.methodA();		
	}

}
