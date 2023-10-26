package com.step1;
//자바에서는 다폴트 패키지 외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하니까 import예약어를 지원함
import javax.swing.JFrame;
//이름지어진 소스이름과 선언된 클래스이름이 다르다
public class JFrameTest4 { //클래스 선언하기 _ 좌중괄호, 우중괄호
	static JFrame jf = new JFrame();
	public static void main(String[] args) {
		//jft는 지역변수이다.
		//메소드 좌중괄호, 우중괄호에서 선언된 변수는 모두 지역변수의 성격임
		JFrameTest3 jft = new JFrameTest3();
		//아래는 주소번지를 두 번 접근해서 메소드를 호출하는 소스임
		//아래에서 호출되는 setTitle메소드는 JFrameTest3에서
		//인스턴스화한 jFrame에 정의된 메소드를 호출하는 것이다.
		jft.jf.setTitle("난 3번이야");
		jft.jf.setSize(500, 400);
		jft.jf.setVisible(true);
		jf.setTitle("난 4번이야");
		jf.setSize(500, 400);
		jf.setVisible(true);
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