package com.basic1;

public class C {
	//전역변수는 초기화 생략 가능 - 왜냐면 생성자가 대신 해주니까
	//자바는 타입마다 디폴트 값을 가지고 있어서 C언어처럼 의미없는 쓰레기값이 출력되는 일 없음.
	
	int x; //나는 전역변수
	int y;
	//11번과 12번이 실행되려면 먼저 무엇을 해야 할까요?
	public static void methodA() {
		int x = 5; //나는 지역변수
		System.out.println(x); //나는 누구일까요? 5 or 0
		//나는 0을 보고 싶어요. 어떡하죠?
		C c = new C();
		System.out.println(c.x); //0
	}
	public void methodB() {
		int x = 5; //나는 지역변수
		//변수(전역변수와 지역변수) 이름이 같을 때 this를 붙여서 구분한다.
		System.out.println(this.x); //나는 누구일까요? 5 or 0
	}
	//클론코딩 순) 24-10-11-12-14-7-15-16-25(methodA호출)-27-17-18-20(출력)-21-28
	//29-30
	public static void main(String[] args) {
		C.methodA();
		//methodB를 호출해 보세요. - insert here
		C c = new C();
		c.methodB();
	}///////end of main/////////////
}//////////end of c //////////////
