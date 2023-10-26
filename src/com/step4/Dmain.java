package com.step4;
//사이드 이펙트 - 부수효과
class D{
	//하나로 합치니 C에 대한 인스턴스화가 필요없게 되었다. - 이러한 이유로 원본 하나가 관리됨
	//그래서 0이 출력되는 게 아니고 240이 출력된다.
	//총점을 담는 변수 선언
	int tot;
	//평균을 담는 변수 선언
	int avg;
	void hap(int n1, int n2, int n3) {
		// 이전 Cmain소스에서는 클래스를 세 개로 나눴다.  -> 두 개로 통합했다.
		//c.tot -> c가 필요없는 건 전역변수가 내 안에 있기 때문이다.
		//이것만으로 복사본이 아니라 원본을 유지(웹: 쿠키와 세션 - 완결편)할 수 있다.
		tot = n1 + n2 + n3;
	}
	//평균을 구하는 메소드 선언
	void average() {
		
	}
}
public class Dmain {

	public static void main(String[] args) {
		int n1 = 70;
		int n2 = 80;
		int n3 = 90;
		D c = new D(); //이 코드가 추가되는 순간 같은 c.tot라도 값이 달라질 수 있다.
		c.hap(n1, n2, n3);
		//insert here - 계산된 총점을 찍고 싶어요. 어떡하죠?
		//우리가 알고 있는 사실은 hap을 구하는 메소드에 리턴타입이 정해지지 않았다.
		//나는 아래에서 0이 출력되는 것을 원하지 않았다. 왜냐면 29번 라인에서 hap메소드를 경유하였다.
		System.out.println(c.tot); //0이 아니라 240이 출력되었다. 어떻게 가능해졌나?
	}

}
