package com.step5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//자바를 자바답게 코딩하기 - 재사용성과 이식성
//효과적으로 코딩을 전개하기 - 추상클래스와 인터페이스 설계하고 구현해 나가기
//클래스 사이의 결합도를 낮춰서 단위테스르 가능하게하고 통합테스트 가능하고
//그러고나서 납품하기(배포하기)
//코드의 양은 늘어나더라도 코드의 복잡도는 늘어나지 않도록 코딩했나? 고민 - 코드리뷰 - 좋은 습관
import javax.swing.JButton;
import javax.swing.JFrame;

class B1{
	JButton jbtnSelect = new JButton("조회");
}
class B2{
	JButton jbtnSelect = new JButton("입력");	
}
public class BMain implements ActionListener{
	JFrame jf = new javax.swing.JFrame(); //JFrame의 javax.swing은 자바 최초 MVC패턴을 API에 적용한 사례
	B1 b1 = new B1(); //위치, 유지(쿠키(로컬), 세션(서버: 캐쉬메모리) - 시간 지배함), 가치, 활용범위(기초가 아니다) - 사이드 프로젝트 - 꾸준히 관찰하기
	B2 b2 = null; //선언만 - 생성자 호출은 없다
	BMain(){
		b2 = new B2(); //생성하기 - 생성자 경유한다.
		/*
		for(double d = 0.0; d<99999.0; d++) {
			System.out.println("지연");
		}
		 */
		initDisplay();
		//b2 = new B2();
	}
	public void initDisplay() {
		//B1 b1 = new B1();
		//이벤트 소스와 이벤트 처리를 담당하는 클래스 연결하기 - 콜백메소드(시스템이 자동으로 호출함 - 시점 결정권이 개발자에게 없다) 호출됨
		//주소번지를 두 번 접근해야 처리가 가능한 경우 -> 2차 배열, 객체 배열, List<Dept>
		b1.jbtnSelect.addActionListener(this);
		jf.add("North", b1.jbtnSelect); //호출이면 재사용성
		jf.add("South", b2.jbtnSelect);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		BMain bm = new BMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//사용자가 누른 버튼에 대한 주소번지 얻어내기
		Object obj = e.getSource();
		if(obj == b1.jbtnSelect) { //조회버튼을 누른거야?
			System.out.println(b1.jbtnSelect.getText());
		}
	}

}
