package com.step1;
//서로 다른 패키지라 하더라도 서로 상속관계에 있으면 접근할 수 있다. -protected
//접근할 수 없다 - friendly상태
class P{ //한 문서 안에 public 두번 올수 없음) //접근제한자가 아무것도 없으면 friendly 상태라 함
	static int i = 1;
	int j = 10;
}

public class Test0920_2 {	
	public void methodC() {
		P.i = P.i + 2; //3
	}
	public static void main(String[] args) {
		//insert here
		P.i = 2;
		System.out.println(P.i); //static 붙은 변수 i는 호출할 때 클래스 이름을 씀(인스턴스변수가 아니라서)
	}/////end of main

}///end of Test0920
/*
	메소드를 선언할때도 좌중괄호와 우중괄호를 사용해서 영역을 표시한다.
	메소드를 호출할때는 세미콜론으로 끝낸다.
*/