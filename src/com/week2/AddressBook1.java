package com.week2;

public class AddressBook1 {
	AddressBook1 abook = null;
	// 제목: 메소드를 활용해서 나는 인스턴스화를 할 수 있다 - 다양한 방법으로 다른 사람이 구현한 클래스를 주입하는 방법에 대해서 학습!
	// spring 프레임워크 - 의존성 주입, 제어역행
	// 1) 메소드 안에서 조건에 따라 인스턴스화를 다르게 가져갈 수도 있다. - 다른 선택지가 생김
	public AddressBook1 getObject() {
		// 이와 같이 null 유무를 체크해서 생성하는 건 하나만 관리하겠다는 것. - 싱글톤 패턴 - 웹개발 - Spring 프레임워크
		if(abook == null) { // 객체를 생성하기 전에 null 체크를 먼저(선처리) 해서 
			abook = new AddressBook1();
		}
		return abook;
	}
	public static void main(String[] args) {
		// 인스턴스화 방법에는 여러가지가 있다.
		AddressBook1 abook = new AddressBook1(); // 기본
	}

}
