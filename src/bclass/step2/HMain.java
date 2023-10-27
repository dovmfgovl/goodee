package bclass.step2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//인스턴스화 -> 필요한 객체를 주입(객체생성 - 관계 - 의존성)받는 것이다. 
//게으른 인스턴스화, 이른 인스턴스화
//Spring에서는 직접 개발자가 절대로(관리받지 못하니까 - 객체 라이프 사이클) 인스턴스화를 하지 않는다. 
public class HMain extends JFrame implements ActionListener {
	JButton jbtn = null;
	String title = null;
	public HMain() { //인스턴스화를 할 때마다 반복해서 호출이 된다.
		//생성자에서 화면을 호출하는 건 인스턴스화 발생 시 두 개의 화면이 열릴 수 있는 것이다.
		jbtn = new JButton("조회");
	}
	public HMain(String title) {
		this.title = title; //전역변수를 초기화 하였다.
	}
	public void initDisplay() {
		new JButton("입력").addActionListener(this); //이벤트가 발동할 때마다 새로운 버튼이 또 생긴다.
		this.add("North", new JButton("입력"));
		this.setTitle(title); //null
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		HMain hm = new HMain("타이틀");
		hm.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
/*
 * 인스턴스화를 하는 방법
 * 1. A a = new A(); 기본
 * 2. A a = null;
 * 		a = new A();
 * 3. A a = B.getInstance(); //싱글톤패턴 - 하나다 - static  대신에 써라
 * 4. Super s = new Sub(); //다형성
 * 		인터페이스 s = new 구현체클래스()
 * 		추상클래스 s = new 구현체클래스()
 * 
 * 인터페이스는 기능적인 관점에서 결합도 낮추면서 재정의 하여 사용하는 컨벤션
 * 
 * 추상클래스(생성자도 가능, 일반메소드도 가능)
 * 		: 서비스의 확장과 관련된 관점
 * 		: 추상클래스는 extends 사용함으로 인터페이스처럼 결합도가 낮지 않고 오히려 강함 - 재사용성 떨어짐(트러블)
 * 
 * 카카오 -> 카카오톡 -> 카카오 선물 -> 카카오페이 -> 카카오뱅크 
 * 전혀 다른 서비스(확장!)
 * 
 * 폭포수 모델 : 분석 - 설계 - 개발 - 테스트 - 배포
 * 
 * 애자일 방법론 : 설계, 프로세스 무시되고 담당자의 요구사항 즉시 반영할 수 있는 방법론
 */
