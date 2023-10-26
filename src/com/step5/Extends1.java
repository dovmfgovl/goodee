package com.step5;
class Super{
	int i;
	Super(){
		System.out.println("Super()호출");
	}
	void methodA() {
		System.out.println("methodA()");
	}
	void methodA(int i) {
		System.out.println("Super methodA(int i)");
	}
}
class Sub extends Super{
	Sub(){
		System.out.println("Sub()호출");
		i = 2;
	}
//	@Override
//	void methodA(int x) {
//		System.out.println("Sub methodA(int x)");
//	}
}
public class Extends1 {

	public static void main(String[] args) {
		Sub sub = new Sub(); //상속받아서 아빠 클래스의 생성자가 먼저 실행-> 자손 같이 출력. 
		System.out.println(sub.i);
		//insert here
		sub.methodA(0);
	}

}
/*
 1. 부모가 가진 전역변수와 메소드 모두는 상속받은 클래스에서 호출이 가능함(지역변수 미포함).
 2. 자손을 인스턴스화 하더라도 먼저 부모 생성자가 호출된다(부모 클래스는 인스턴스화 하지 않더라도).
 3. 동일한 메소드가 부모와 자손 둘 다 있을 때 부모 메소드는 shadow method가 된다.
 4. 부모가 가지고 있는 메소드를 override하여 사용할 수 있으나 리턴타입이나 ___를 바꿀 수 없다.
 
 Q) 상속받은 클래스가 더 누릴 수 있다. | 아니다 자손 클래스가 더 누릴(변수와 메소드) 수 있다.
 A) 여러 계층의 상속관계를 가진 클래스의 경우 가급적 하위 클래스를 상속받는 것이 더 많은 변수와 메소드를 누릴 수 있다. - 기억!!!
 */

