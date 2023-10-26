package bclass.step2;
//인스턴스 변수와 클래스 변수
//싱글톤 패턴- static(클래스급 - 인스턴스화가 필요없다) - 웹서비스 구현(html, css, javascript, REACT) -
//자바로는 웹서비스를 제공할 수 없다. - 왜냐하면 자바 API에는 Http프로토콜을 지원하는 API가 없다.
//과거 Applet으로 화면을 그림 - JFrame과 차이점은 브라우저에서 자바클래스를 호출할 수 있었다.
//Sever에서 동작하는 Applet을 지원하자 - Serv + let -> Servlet -> 멀티스레드 내장 + 싱글톤 패턴 서비스를 완성하게 됨
//1초에 2000명이 접속 한다면 인스턴스화를 2000개 생성함 - 각각 다른 사람이고 각각 다른 서비스를 제공해야하니까
//복제본 만들어짐 - 각각의 변수가 서로 다른 값을 쥐고 있다.(VO) -> private(제약조건 - 고립화) -> 캡슐화 -> 메소드를 통해서 객체를 읽고 쓴다
//메소드를 통해서 값을 제공하다보니 if문을 써서 유효성 체크도 가능하다 -> 객체 생성하기를 new(생성자를 사용하지 않고)가 
//메소드의 리턴타입을 통해서 객체를 받게 해주자
class A{
	
}
public class AMain {

	public static void main(String[] args) {
		A as[] = new A[3];//객체 배열
		//as[0], as[1], as[2] = null 세 번 출력한다.
		A a = new A();
		as[0] = a; //null ->@abcd1234 - 치환하기(기초가 아니다) - 참조형타입 치환! 점검해보기!
		for(A a1 : as) {
			System.out.println(a1); //null, null, null (20번이 막혀있다면) -> 주소번지, null, null (20번이 있다면)
		}
	}

}
