package com.week1;
//메소드의 파라미터로 참조형을 사용하는 방법에 대해서 알려주세요.
class Sonata{
	int speed = 0; //현재 소나타는 주차되어 있다.
	String carColor = "빨강";
}
//만약 여러 개의 값을 반환하고 싶다면 참조형 타입을 사용하면 된다.(1-3)
public class WReturn3 {
	//메소드의 리턴타입으로 참조형 변수를 사용할 수 있다.
	//메소드 호출을 통해서도 클래스를 메모리에 로딩할 수 있다.
	Sonata getCar() {
		//아래에서 소나타 객체를 생성하였다.
		Sonata himCar = new Sonata();
		//그리고 return으로 그 변수를 반환할 수 있다.
		return himCar;
		//return new Sonata(); //위 두 문장을 한 문장으로 줄이면 이거...!?
	}
	public static void main(String[] args) {
		//아래 인스턴스를 한 이유는 getCar() 호출하기 위해서 하였다.
		WReturn3 wr = new WReturn3();
		Sonata myCar = new Sonata();
		System.out.println(myCar.carColor);
		//여기서 getCar메소드를 호출하였고 리턴타입으로 Sonata객체를 참조하는 변수가 선언됨.
		Sonata himCar = wr.getCar();
		System.out.println(myCar); //@4e50df2e
		System.out.println(myCar.carColor); //빨강
		himCar.carColor = "검정색";
		System.out.println(himCar); //@1d81eb93
		//검정색 자동차는 현재 30km로 달리고 있다.
		//빨강색 자동차는 현재 0km를 가리키고 있다. 
		System.out.println(himCar.carColor); //검정색
		himCar.speed = 30;
		System.out.println(himCar.speed); // 30
	}

}
