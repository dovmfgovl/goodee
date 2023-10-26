package com.step1;
//자바에서는 다폴트 패키지 외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하니까 import예약어를 지원함
import javax.swing.JFrame;
//이름지어진 소스이름과 선언된 클래스이름이 다르다
public class JFrameTest3 { //클래스 선언하기 _ 좌중괄호, 우중괄호
	static JFrame jf = new JFrame();
	public static void main(String[] args) {
		JFrameTest3 jft = new JFrameTest3();
		jf.setSize(500, 400);
		jf.setVisible(true);
	}

}