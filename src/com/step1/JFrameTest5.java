package com.step1;
//자바에서는 다폴트 패키지 외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하니까 import예약어를 지원함
import javax.swing.JFrame;
//이름지어진 소스이름과 선언된 클래스이름이 다르다
public class JFrameTest5 { //클래스 선언하기 _ 좌중괄호, 우중괄호
	JFrame jf = new JFrame(); //전역변수의 성격-메소드 안에 선언하지 않았다.
	//인스턴스변수.변수명으로 호출이 가능함 -> 전역변수
	public static void main(String[] args) {
		//내 안에서 선언된 변수이더라도 static영역안에서 non-static변수를 호출할 때는
		//인스턴스화를 해야 한다.
		JFrameTest5 jft = new JFrameTest5();
		//해결방법은 주소번지를 두 번 접근해야만 한다.
		jft.jf.setTitle("난 5번이야");
		jft.jf.setSize(500, 400);
		jft.jf.setVisible(true);
	}
}
/*
 * 
지역변수는 local variable 또는 automatic variable이라 함

윈도우 창이 두 개가 열린다.
왜지?
인스턴스화가 두 번 일어났으니까...
JFrameTest4클래스에 선언된 메인메소드가 호출되었다??
그 안에서 JFrameTest3을 인스턴스화를 하였다.
결론: 내가 구현한 메소드가 아니더라도 그 메소드를 소유하고 있는 클래스를 인스턴스화 하면 그 클래스의 메소드를 나는 호출할 수 있다.
*/