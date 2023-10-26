package com.week2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
// 클래스 선언하기
// ActionListener는 인터페이스라서 추상메소드를 가지고 있다.
//추상메소드란 선언만 되어있고 좌중괄호와 우중괄호가 없는 메소드를 말함
public class AddressBook extends JFrame implements ActionListener {
	// 선언부
	//JFrame jf = new JFrame(); // extends 안하면 이렇게 인스턴스화 해서 this 대신 jf로 붙여 사용가능
	AddressDialog aDialog = new AddressDialog(); // 생성부가 생성자를 호출한다.
	JPanel jp_north = new JPanel(); // 버튼 4개 배치하는데 사용함 - 단독으로는 모양이 없다.
	JButton btnSelect = new JButton("조회");
	JButton btnInsert = new JButton("입력");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	// 생성자
	public AddressBook() {}
	// 화면처리
	public void initDisplay() {
		// 이벤트 처리 3단계
		// 1. 버튼의 이벤트를 지원하는 인터페이스를 implements 한다. - ActionListener 사용
		// 2. 해당 인터페이스가 선언하고 있는 메소드를 오버라이딩 해야한다 - actionPerformed(ActionEvent e)
		// 3. 이벤트 소스(버튼 4개)와 이벤트 처리를 담당하는 클래스(actionPerformed)를 매칭해줌
		btnSelect.addActionListener(this); // this는 ActionLIstener 구현하고 있는 구현체 클래스를 가리킨다 - AddressBook
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		jp_north.add(btnSelect);
		jp_north.add(btnInsert);
		jp_north.add(btnUpdate);
		jp_north.add(btnDelete);
		this.add("North", jp_north);
		this.setTitle("주소록 Ver1.0");
		this.setSize(800, 500);
		this.setVisible(true);
		aDialog.initDisplay();
		aDialog.jdg_address.setVisible(false);
	}
	// 메인메소드
	public static void main(String[] args) {
		AddressBook abook = new AddressBook(); 
		abook.initDisplay();
	}
	// 아래 메소드는 ActionListener 인터페이스에 이름이 정해져 있다.
	// 구현체 클래스인 네가 재정의하여 구현해라
	// 현재 코드에서 actionPerformed 메소드를 호출하는 코드는 어디에도 없다.
	// 그런데 55번 라인은 어떻게 실행되는 걸까?
	// actionPerformed 메소드는 마치 main메소드처럼 버튼이 눌려지고 눌려졌다는 사실을 JVM이 감지하면
	// 그때 자동으로 호출되는 메소드 입니다. - 콜백메소드(callback)
	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌려진 버튼의 문자열을 읽어온다 - 언제? 버튼이 눌렸을 때 - 버튼을 누르는 건 사용자 이지만
		//눌렸다를 느끼는 건 JVM만이 알 수 있다. - 파라미터 자리에 e가지고 getActionCommand() 호출하면 String타입의 라벨 출력함
		String command = e.getActionCommand();
		System.out.println(command);
		//너  조회를 원해?
				if("조회".equals(command)) { // command 안에 '조회,입력,수정,삭제 라벨'을 갖게 되고 그 중 버튼 누른 라벨을 상수 "조회" 값과 비교
					System.out.println("조회버튼을 클릭하였습니다.");
					//AddressDialog의 title에 라벨된 command 값을 넣고, isView자리에 true를 파라미터로 입력하여 창이 뜨도록 만듦. 중복제거도 가능해짐(아래와 같은)
					// 또한 중요한 정보는 AddressDialog에 숨겨 보안을 높이고, 함부로 건드려 터지지 않도록 함.
					aDialog.set(command, true); 
//					aDialog.jdg_address.setTitle("조회");
//					aDialog.jdg_address.setVisible(true);
				}
				//너  입력하려고?
				else if("입력".equals(command)) {
					aDialog.set(command, true);
				}
				//너 수정할거니?
				else if("수정".equals(command)) {
					aDialog.set(command, true);
				}
		// 너 삭제할래?
	}

}
