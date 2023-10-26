package com.step1;

public class Test0920_4 {	
	//메인메소드는 콜백이라서 개발자가 호출할 수 없다.
	public static void main(String[] args) {
		//insert here
		Test0920_2 t2 = new Test0920_2();
		//첫번째 호출되었을 때 1에서 2가 더해진 결과가 유지되고 있었다.
		t2.methodC();
		//위 코드에서 methodC를 경유하였으므로 P클래스의 정적변수 i는 1에서 3으로 변경됨
		//
		t2 = new Test0920_2();
		t2.methodC();
		//아래에서 3이 출력될 것이다? 5가 출력될 것이다?
		//3이라고 한 사람- 인스턴스화 했을 때 새로 초기화가 1로 되었다.
		//5라고 한 사람- 인스턴스화를 두 번 했고 메소드도 두 번 호출했잖아
		System.out.println(P.i); //1 -> 3 -> 5
	}/////end of main
}///end of Test0920