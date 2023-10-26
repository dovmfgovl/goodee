package com.step6;

public class Me2 extends Super2 {
	@Override
	public void methodC() {
		System.out.println("Me2 : methodC() 호출");
	}
	public static void main(String[] args) {
		Me2 me = new Me2();
		Super2 sup1 = new Me2();
		Super2 sup11 = new Super2();
		System.out.println(me.a);
		//Me2 타입은 Super2만 상속 받았지만 그 전에 Super1을 상속받고 있으므로 Super1에서 정의된 메소드 호출은 합법
		me.methodA();
		sup1.methodA();
		//상위 클래스 타입의 인스턴스 변수로 하위 클래스에 정의된 메소드 호출불가함
		//만일 오버라이드 관계에 있어도 불가능한 것인가?
		sup1.methodC(); //sup1은 Super2 타입인데 생성된 객체는 Me2 타입이다. 그래서 헷갈린다. => 상위 클래스는 쉐도우 클래스가 되어 구현체 클래스가 재정의한 것으로 호출됨
		sup11.methodC(); //sup11은 Super2에 정의된 메소드가 호출됨
		me.methodC(); //Me2가 출력될 것이다.
	}

}
