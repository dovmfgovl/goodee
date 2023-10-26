package com.week2;

public class Pride {
	int speed = 0; // 자동차가 전시장에 주차된 상태를 상상
	// 생성자 - 파라미터가 없는 생성자는 JVM이 대신 주입해줌 - 그래서 지금까지 안했음
	public Pride() {
		System.out.println("Pride() 디폴트 생성자 호출 성공");
		speed = 10; // 왜 인스턴스 변수 없이도 접근이 가능한거죠?
	}
	// 9 - 11 - 12 - 5 - 6 - 13
	public static void main(String[] args) {
		// 선언만 하면 주소번지가 할당되지 않음 - 그러면 사용할 수 있어요? - 안됨 - NullPointerException 발생해서 안돼
		Pride myCar = null; // 선언만 했다 - myCar의 타입만 결정되었다(실체는 없다, 가리키는 객체 없다(주소번지 할당되지 않음)).
		myCar = new Pride(); // 생성도 하였다 - 이때 주소번지가 결정되었다.
		System.out.println(myCar.toString());
		int speed = 100;
		myCar.speed = 20; // 전역변수만 이렇게 쓸 수 있음
		//speed = 30; // static 영역 안에서 non-static 타입의 변수는 접근이 불가하다.
		// 만일 가능하게 하려면 인스턴스변수.speed로 호출할 수 있다. 재정의 할 수 있다. 초기화 할 수 있다.
		System.out.println(myCar.speed); // 0 -> 10 -> 20
	}

}
