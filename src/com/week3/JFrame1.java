package com.week3;

import javax.swing.JFrame;

public class JFrame1 {
	//선언부
	int width; //0
	int height; //0
	JFrame jf = null;
	//생성자(생성자의 기본 역할: 전역변수의 초기화)
	JFrame1(){
		System.out.println("디폴트 생성자 호출");
		jf = new JFrame();
		String title = "토마토님의 대화창";
		jf.setTitle("입력 | 수정 | 상세보기");
		jf.setTitle(title); //토마토님의 대화창
		System.out.println(jf);
	} //디폴트 생성자라 함
	JFrame1(int width, int height){ //생성자 파라미터의 값들은 호출할 때, 인스턴스화(선언, 생성도 포함) 할 때 가짐.
		System.out.println("파라미터가 있는 생성자 호출");
		System.out.println("지역변수 width : " + width + ", 전역변수 : " + this.width + ", 지역변수 height : " + height + ", 전역변수 : " + this.height);
		this.width = width;
		this.height = height;
		System.out.println("지역변수 width : " + width + ", 전역변수 : " + this.width + ", 지역변수 height : " + height + ", 전역변수 : " + this.height);
		System.out.println(jf);
		jf = new JFrame("제목을 출력해줌");
	} //생성자라 함
	//사용자 정의 메소드
	public void initDisplay() {
		this.width = 900;
		this.height = 700;
		jf.setSize(width, height); //전역변수로 선언했으니 다른 메소드에서도 접근 가능함
		jf.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		JFrame1 jf1 = new JFrame1();
		jf1.initDisplay();
		
	}

}
