package com.step4;
//외부에 있는 정보(원시형 타입, 참조형 타입)를 재사용하고 싶다면?
//데이터는 가로 방향과 세로 방향
//가로 방향은 서로 관계가 있다.
//그 사람의 나이, 키, 혈액형 -> 참조형 타입으로 설계해야 한다.
//세로 방향은 2500만 가입자의 이름 -> 배열 - 같은 타입만 담을 수 있다.
//클래스와 배열은 모두 new사용해서 생성한다.
class B{ //변수만 있고
	int age = 0; //전역변수
}
class B1{ //메소드만 가진다
	//메소드의 파라미터를 통해서 복사본 대신 원본을 넘겨서 그 원본이 가리키는 전역변수의 값을 출력한다.
	B b = new B();
	void methodA(B b) {
		b.age = b.age + 1; 
	}
}
public class Bmain {

	public static void main(String[] args) {
		B b = new B();
		B1 b1 = new B1();
		b1.methodA(b);
		// 가설2 - 영향이 있다.
		System.out.println(b.age); //1이 출력될 것이다.
	}

}
