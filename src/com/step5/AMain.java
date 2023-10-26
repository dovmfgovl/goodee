package com.step5;
class A1{
	public A1(AMain aMain) {
		System.out.println("A1에서 출력한 AMain원본"+aMain);
	}
	//경유한다 - 실행문을(초기화, 재정의, if문 - 흐름이 바뀐다 - boolean - 결과가 달라진다)
	public A1() {
		// TODO Auto-generated constructor stub
	}

	int i;
}
class A2{
	public A2(AMain aMain) {
		System.out.println("A2에서 출력한 AMain 원본"+aMain);
	}

	public A2() {
		// TODO Auto-generated constructor stub
	}

	void methodA() {
		System.out.println("methodA 호출 성공");
	}
}
public class AMain {
	A1 a1 = new A1(this); //인스턴스화는 이미 생성자를 포함하고 있다.
	A2 a2 = new A2(this); //인스턴스화는 이미 생성자를 포함하고 있다.
	public static void main(String[] args) {
		//static 내부에서는 this나 super 예약어는 사용 불가함
		AMain am = new AMain(); //생성자 호출 -> 전변의 초기화 -> 생성자 경유
		//파라미터를 갖는 생성자가 하나라도 존재하면 디폴트 생성자 마저도 제공 안 됨
		A1 a1 = new A1();
		System.out.println(a1.i); //0
		A2 a2 = new A2();
		a2.methodA();
	}

}
