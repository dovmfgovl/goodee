package com.step1;

public class Test0920_1 {
	int i = 1; //전역변수 - 같은 변수명 사용 불가
	//int i = 2; 
	public void methodA() {
		int i = 2; //지역변수 - 같은 변수명 사용 가능
		//int i = 3;
		//메소드 내에서 선언된 변수는 모두 지역의 성격. 그래서 메소드이름이 다르며 같은 변수이름 사용 가능.
		Test0920_1 t1 = new Test0920_1();
		//왜 나는 여기에 인스턴스화를 했을까? -> t1.j t1.i
		//인스턴스변수.전역변수
		//지역변수는 인스턴스변수.호출 할 수 없다
		int j; //초기화 안해도 오류 안뜨는 이유: 아직 사용하지 않았다(호출하지 않았다). 재정의 할 기회가 남아있기 때문.
		j = 4; //초기화 시키면 오류 없어짐
		//System.out.println("methodA호출 성공"+j); //j쓰면 오류 뜸
		System.out.println("j====>" + t1.j);
	}
	//9-11-12-5-6-7-13-14
	public static void main(String[] args) {
		//insert here
		Test0920_1 t1 = new Test0920_1(); //인스턴스화. 이때 t1은 인스턴스변수.
		t1.methodA();
	}/////end of main

}///end of Test0920
/*
	메소드를 선언할때도 좌중괄호와 우중괄호를 사용해서 영역을 표시한다.
	메소드를 호출할때는 세미콜론으로 끝낸다.
*/