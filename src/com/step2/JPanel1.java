package com.step2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanel1 {
	//setSize 메소드의 파라미터는 int이다. 따라서 int 타입을 선언한다.
	int width = 300;
	int height = 500;
	//false이면 메모리에는 로딩중이나 화면에만 안보임
	//true이면 메모리에도 존재하고 실제 화면상에도 보임
	boolean isView = false;
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JTextField jtf = new JTextField("");
	//화면을 그리는 메소드 선언
	public void initDisplay() {
		jp.setBackground(Color.green); //메소드 호출하기 - 파라미터는 반드시 Color타입이어야 함
		jp.setBackground(Color.red);
		//setSize 메소드와 setVisible 메소드는 JFrame 클래스가 정의하고 있는 메소드이다.
		jf.add("Center", jp); //add메소드는 파라미터를 두 개 넣어야 하고 첫번째는 String, 두번째는 화면에 붙일 주소번지 사용
		jf.add("South", jtf);
		jf.setSize(width, height); //첫번째 파라미터 자리는 화면의 가로 길이를 입력받고, 두번째 자리는 화면의 높이를 입력 받음
		jf.setVisible(isView); //setVisible메소드의 파라미터 자리에는 true 혹은 false가 올 수 있음
	}

	public static void main(String[] args) {
		//insert here에서 initDisplay() 호출하시오.
		JPanel1 jp1 = new JPanel1();
		jp1.isView = true;
		jp1.initDisplay();

	}
}
