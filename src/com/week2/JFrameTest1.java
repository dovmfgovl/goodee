package com.week2;

import javax.swing.JFrame;

public class JFrameTest1 extends JFrame {
	// 파라미터가 한 개도 없으니까 JVM이 대신 만들어줄 수 있다.
	// 파라미터가 있으면 만들어줄 수 없다. - 왜냐면 JVM이 임의로 정하면 안되니까
	public JFrameTest1() { // 파라미터가 없는 생성자를 디폴트 생성자라 함
		System.out.println("디폴트 생성자 호출");	
		//생성자 안에서는 static이 없어서 인스턴스 변수 없이도 사용가능함
		initDisplay();
		// 아래 메소드는 이름은 같지만 파라미터의 갯수가 달라서 다른 메소드로 인지함
		methodA();
	}
	// 사용자 메소드 정의하기 - 화면을 출력하는 메소드 선언해 보기
	public void initDisplay() {
		System.out.println("디폴트 생성자 호출");
		//내(JFrameTest1) 안에 선언된 메소드(setSize(int, int))가 아니다. 그럼 어디에? - JFrame에 있다.
		// this는 자바가 제공하는 수정자이고, 보통 자기자신을 가리킬 때 사용함
		// 주로 전변과 지변의 이름이 같은 경우 구분하기 위해 개발자가 명시적으로 붙여줌 - 생략하지 않음
		this.setSize(500, 400); // 메소드 호출이다.
		this.setVisible(true);
	}
	public void methodA() {
		System.out.println("methodA() 호출");
	}
	public void methodA(JFrameTest1 jft) {
		System.out.println("methodA(JFrameTest1) 호출");
		System.out.println(jft);
	}
	//22-23-8-9-10-24-12-13-17-18-19-24
	//
	public static void main(String[] args) {
		// main 메소드 내부에서 인스턴스화를 하면 지변의 성격을 갖는다.
		JFrameTest1 jft = new JFrameTest1();
		System.out.println(jft); // 지변이지만 메소드 호출시 파라미터를 통해서 원본을 넘길 수 있다.
		//new JFrameTest1().methodA();
		// 아래는 변수 이름이 없어서 에러발생 - 변수이름 사용할 수 없다면 생성자 위치로 옮겨서 할 수 있다.
		// 변수이름이 없으면 지역변수로 선언되어 참조되는 클래스를 다른 메소드에서 재사용이 불가능하다.
		// 1. 메소드 파라미터 자리가 원시형 타입인 경우 + 갯수 판단하고 결정 처리
		// 2. 메소드 파라미터 자리가 참조형 타입인 경우 + 동일
		jft.methodA(jft);
	}

}
