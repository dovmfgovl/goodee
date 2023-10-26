package com.step4;
//인스턴스화가 A a = new A();
//역할은? a.전변호출한다. a.사용자정의메소드 호출한다.
class L{
	int i = 1; //전역변수 선언 - 외부클래스에서 접근 가능하다 - 단, 인스턴스화 해야 함
}
public class Lmain {
	void methodA(L l) { //메소드 구현은 좌중괄호 우중괄호로 끝남
		System.out.println("호출 성공" + l);
		int j = l.i; //대입연산자 - 오른쪽의 값을 왼쪽에 대입
		System.out.println(j);
	} //end of methodA()
	//14-19(인스턴스화)-20-21-8(메소드호출)-9-10(재정의, 초기화, 치환, 지변)-11
	public static void main(String[] args) {
		//Lmain클래스에서 L클래스에 정의된 전역변수 i를 사용하고 싶다면?
		//Lmain안에서 L클래스가 인스턴스화 되어야 한다.(제어권을 Spring이 가짐 <-- Spring이 대신 인스턴스화 해주는 것 <-- 객체 라이프 사이클 관리해줌)
		//인스턴스화의 여러 방법 꼭 체크해보기!! - 새로운 시야 갖게 해줌
		//어떤 클래스명으로 인스턴스화를 진행할건가요?
		L l = new L(); // 지변의 성격이다.
		Lmain lm = new Lmain();
		lm.methodA(l); //메소드 호출은 세미콜론
	}

}
