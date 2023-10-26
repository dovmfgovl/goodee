package com.step1;
//자바에서는 다폴트 패키지 외에는 모두 패키지명을 다 적어야 하는데
//반복되는 코드가 발생하니까 import예약어를 지원함
import javax.swing.JFrame;
//이름지어진 소스이름과 선언된 클래스이름이 다르다
public class JFrameTest2 { //클래스 선언하기 _ 좌중괄호, 우중괄호
	JFrame jf = new JFrame();
	//선언부에서는 선언과 초기화를 두 줄에 나누어 적을 수 없다.
	int i; //선언만-전역변수
	int j = 10; //새로 선언한 변수다.
	//jf.setSize(500, 400);
	//jf.setVisible(true);
	//사용자 정의 메소드인 initDisplay()지웠다
	//메인메소드 선언 - 개발자가 호출하지 않아도 제일 먼저 실행됨 - 누가? JVM이 호출
	public static void main(String[] args) {
		//insert here
		//누구를 인스턴스화 해야 할까요?
		JFrameTest2 jft = new JFrameTest2();
		//왜 빨간줄이 떴나? - 내가 선언한 클래스 안에 initDisplay() 메소드가 구현되지 않았음
		//jft.initDisplay(); //메소드 뒤에 {}, 메소드 이름뒤에 세미콜론이 오면 호출이다.(선언이 우선되어야 함)
	}

}
/*
클래스 선언이 먼저이다. - 인스턴스화 먼저 이야기 해드림
인스턴스화라는 건 메모리(RAM)에 개발자가 작성한 문서를 로딩하는 것이다. 
클래스 이름에 빨간줄은 JVM이 해당 클래스 이름을 찾을 수 없을 때 표시
java폴더 아래 lang폴더에 있는 것만 찾을 수 있다.
 */
