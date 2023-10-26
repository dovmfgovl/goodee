package com.step1;

//변수의 종류
//1) 원시형 타입(primitive data type) - int, double, boolean
//2) 참조형 타입(reference data type) - 클래스 인것은 모두 여기에 해당됨
//변수의 선언 위치에 따라, 변수 선언시 붙는 수정자에 따라서
//전역변수 - 인스턴스변수,전역변수만 가능하고. 전역변수는 초기화를 생략할 수 있다(디폴트 값이 정해져 있다). 생성자가 대신 해주니까
//지역변수 - 인스턴스변수, 지역변수 호출은 불가함(불법 - 컴파일 안됨). 지역변수는 초기화를 생략할 수 없다.
//정적변수 - 클래스타입.변수명으로 사용함(싱글톤, 하나다, 공유된다)

public class Sonata { //접근제한자 class예약어 사용함 - 클래스 선언 클래스이름을 지어준다 - 대문자로 시작하라 -낙타표기법(camel case)
	//선언부 - 선언부에 선언하는 변수는 전역변수이다(global variable, member variable)
	//자동차를 생각나게하는 고유명사 - speed, wheelNum, carColor
	//타입 변수이름 대입연산자 값
	int speed = 0; //호출하면 값이 나온다 - 원시형타입(primitive data type)
	int wheelNum = 4;
	String carColor = "검정색"; //대문자로 시작하는 건 클래스이다. - 참조타입(reference data type)
	public static void main(String[] args) {
		//선언과 생성을 나누어 작성하면 시점의 문제를 당할 수 있다(NullpointerException).
		//myCar - 인스턴스화에 사용된 변수를 인스턴스변수라고 한다. 
		//인스턴스변수를 통해서 호출할 수 있는 건 전역변수 뿐이다.
		//지역변수는 불가하다.
		Sonata myCar = null; //선언만 했다. 아직 생성하지 않았다. 아직 사용할 수 없다(변수 myCar를. 타입만 결정되었다.
		myCar = new Sonata();//생성하였다. 사용할 수 있다. myCar를 전역변수 호출하는데 사용하더라도 NullpointerException이 발생하지 않는다.
		Sonata herCar = new Sonata();
		herCar.speed = 50;
		System.out.println(myCar.speed); //0 
		//원시형 타입에는 한번에 하나만 담을 수 있다. - 장애
		//동시에 두개의 값을 가질 수 없다. 
		System.out.println(herCar.speed);//50
	}

}
