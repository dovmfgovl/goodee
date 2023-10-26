package com.step6;
//다형성
//같은 메소드를 호출했는데 그 결과가 달라진다.
//me.methodB(), sup1.methodB() 결과가 다름
public class Me extends Super1 {
	public void methodC() {
		System.out.println("methodC() 호출");
	}
	public static void main(String[] args) {
		Me me = new Me();
		Super1 sup1 = new Me();//앞에 상위 클래스, 인터페이스가 오고, 뒤(생성부)에 오는 타입이 다른 것이 옴으로. 동일 메소드를 호출해도 다른 기능 구현될 수 있다.
		Super1 sup11 = new Super1();
		System.out.println(me.a);
		me.methodA();
		sup1.methodA();
		//상위 클래스 타입의 인스턴스 변수로 하위 클래스에 정의된 메소드 호출 불가함
		sup1.methodC();
		sup11.methodC();
		me.methodC();
	}

}
