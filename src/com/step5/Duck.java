package com.step5;
//추상클래스
//추상클래스는 추상메소드와 일반메소드 모두를 가짐
//생성자도 가짐
//변수선언도 가능함
//인터페이스는 일반메소드는 못 가짐
//추상클래스와 인터페이스의 공통점: 둘 다 반드시 구현체 클래스가 있어야 함
//추상클래스의 구현체 일 땐 extends 사용
//인터페이스의 구현체 일 땐 implements 사용
public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuakBehavior quakBehavior = null;
	public Duck() {}
	public abstract void display(); //메소드가 ;끝나면 호출이다(추상클래스에서는) - 메소드 오버라이딩 대상이다 - 반드시 구현할 것 - 강제성 - 명세서이다.
	public void performFly() {
		flyBehavior.fly();
	}
	public void performQuack() {
		quakBehavior.quack();
	}
	public void swimming() {
		System.out.println("모든 오리는 물 위에 뜬다.");
	}
}
