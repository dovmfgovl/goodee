package com.week3;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeView {
	//선언부 - 선언부에서는 메소드 호출 불가함
	JFrame jf = new JFrame();
	Font font = new Font("돋움체", Font.BOLD, 30);
	JLabel jlbTime = new JLabel("현재시간정보", JLabel.CENTER);
	//TimeClient tc = new TimeClient(jlbTime);
	//실제 현재 시간 정보를 청취하는 TimeClient클래스에서 TimeView의
	//JLabel과 JFrame을 모두 접근할 수 있어야 하니까 this를 넘긴다.
	//TimeView를 받으면 전역변수 모두를 다 접근할 수 있어서.. 그렇게 했다.
	//TimeView에서 생성한 화면이지만 사용은 TimeClient에서 하겠다면
	//생성자의 파라미터를 통해서 현재 로딩된 TimeView 전체를 넘긴다.
	TimeClient tc = new TimeClient(this);
	//생성자
	TimeView(){
		
	}
	public void initDisplay() {
		System.out.println("TimeView : "+jlbTime);
		tc.start();
		jlbTime.setFont(font);
		jf.add("North", jlbTime);
		jf.setSize(700, 400);
		jf.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		TimeView tv = new TimeView();
		tv.initDisplay();
	}

}
