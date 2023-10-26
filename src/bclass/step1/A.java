package bclass.step1;
//*******************주석 처리 추가, 제외 하면서 값 이해하기
public class A {
	int i; //전역변수 선언하기 - 클래스 설계
	public A() {
		System.out.println("A()디폴트 호출");
		i = 10;
	}
	public A(int i) {
		this(); // this 예약어로 디폴트 생성자 호출 가능
		System.out.println("A(int i) 호출");
		this.i = 50;
	}
	public A(int i , int j) {
		this(0);
	}
	void methodA() { //메소드 선언 - 클래스 설계 일부
		
	}
	//해당 메소드 내에서만 유지됨 - 메소드 영역 벗어나면 유지되지 않음
	//내부에서 처리된 결과가 한정적이다. - 인스턴스 변수에 대해서 한정됨
	//만약 외부에서 유지되기를 원하면 전역변수로 치환 or 리턴타입 활용
	void methodA(int i) { //메소드 오버로딩 - 파라미터가 투입되었다 - 지역변수 - 스택메모리 거주(그러므로 자동 소멸)
		//인스턴스화를 할 때마다 새로운 객체 생성됨 - 주소번지가 달라진다.
		System.out.println("methodA(i) 호출");
		A a = new A(); // 아래와 타입은 같지만 서로 다른 객체
		a.i = 20;
		System.out.println(a.i); //20
	}
	public static void main(String[] args) {
//		A a = new A();
//		System.out.println(a.i); //처음엔 0이었지만 생성자 호출되어 생성자 안에서 재정의됐으니 10출력
//		A a = new A(0);
//		System.out.println(a.i); //10 //this(); 없애면 0
		A a = new A(0,0);
		System.out.println(a.i);
		a.methodA(0);
	}
}
