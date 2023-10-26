package com.step4;
class C{
	//총점을 담는 변수 선언
	int tot;
	//평균을 담는 변수 선언
	int avg;
}
class C1{
	//C c = new C();
	//총점을 구하는 메소드 선언
	//파라미터 자리는 초기화가 안 되어 있다. - 그럼 언제 되지? - 메소드가 호출될 때 - call by value
	//리턴타입을 void에서 int로 가져가는 순간, Cmain에서 C에 대한 인스턴스화가 필요없게 됨.
	//왜 굳이 인스턴스화를 하게 되었나?
	//리턴타입이 void여서 메소드의 처리결과를 유지할 방법이 없었다.
	//그런데 지금은 return타입이 생겼다. 그래서 메소드 호출을 통해 반환받을 수 있게 되었다.
	//단, 인스턴스화가 달라지면 그 값은 당연히 변할 것이고 
	//tot를 전역변수로 할 이유가 사라졌다.
	//또 다른 방법이 있을까? - 전변을 살려서 처리할 수 없을까?
	int hap(int n1, int n2, int n3, C c) { //call by reference(참조에 의한 호출: C c = null)가 되어서
		c.tot = n1 + n2 + n3;
		return c.tot;
	}
	//평균을 구하는 메소드 선언
	void average() {
		
	}
}
public class Cmain {

	public static void main(String[] args) {
		int n1 = 70;
		int n2 = 80;
		int n3 = 90;
		C c = new C();
		C1 c1 = new C1();
		//9번에 인스턴스화를 하지 말고(하지 않고서도)
		//hap메소드 안에서도 C클래스에 대한 인스턴스화가 필요하였고 main메소드 안에서도 전변 tot를 출력하기 위해서 필요하였다.
		//그런데 c.tot보다 메소드 호출이 먼저니까 C에 대한 인스턴스화를 진행함
		//그 주소번지를 hap메소드의 파라미터로 넘기면 원본을 넘기는 것이니까 c.tot가 유지된다.
		int tot = c1.hap(n1, n2, n3, c);
		//insert here - 계산된 총점을 찍고 싶어요. 어떡하죠?
		//우리가 알고 있는 사실은 hap을 구하는 메소드에 리턴타입이 정해지지 않았다.
		//나는 아래에서 0이 출력되는 것을 원하지 않았다. 왜냐면 40번 라인에서 hap메소드를 경유하였다.
		System.out.println(c.tot); // 0 -> 240 출력된다.
	}

}
/*
 	1. 전역변수 활용해서 처리하는 방법
 	: 클래스의 구조를 변경한다(클래스의 숫자를 2개로 줄였다).
 	: 메소드 호출시 파라미터 자리에 참조에 의한 호출로 처리하였다.
 	2. 지역변수 활용해서 처리하는 방법
 	: 메소드의 리턴타입을 이용하였다.
 */









