package com.step21;

import java.util.Scanner;

class E {
	//jvm은 jvav.lang폴더 안에 있는 클래스만 알고 있다.
	//나머지 폴더에 있는 클래스는 반드시 import문 추가해야함.
	//인스턴스화를 할 때도 메소드와 동일하게 파라미터 갯수나 타입을 맞춰야 함.
	Scanner sc = new Scanner(System.in); //인스턴스화도 전역에서 하는 것과 지역에서 하는 것을 나누어 연습 할 필요가 있다. 
	//getFirst메소드를 선언해서 사용자로부터 숫자를 입력받는
	//메소드를 구현해보시오.
	public int getFirst() {
		int num = 0;
		//전역변수 자리에서 sc를 생성했으므로 getFirst메소드 안에서도 sc변수를 사용할 수 있다!!
		num = sc.nextInt();
		return num; //전역변수로 할까? 아님 지역변수로 해야 할까? -> 지역변수로!!! 사용자가 계속 숫자를 바꿔입력하니까 잠깐만 기억하면 됨으로
	}
	public int getSecond() {
		int num = 0;
		num = sc.nextInt();
		return num;		
	}
	public int add(int first, int second) {
		first = sc.nextInt();		
		second = sc.nextInt();		
		return first + second;
	}
	public int minus(int first, int second) {
		first = sc.nextInt();		
		second = sc.nextInt();
		return first - second;
	}
	public int multi(int first, int second) {
		first = sc.nextInt();		
		second = sc.nextInt();
		return first * second;
	}
	public double divide(int first, int second) {
		first = sc.nextInt();		
		second = sc.nextInt();
		return first / (double)second;
	}
}
public class Emain {
	//Random r = new Random();
	//int dap = r.nextInt(10); //0.0~10.0인데 0.0은 포함하고 10.0은 포함하지 않는 그 사이의 정수값이 채번됨.
	public static void main(String[] args) {
		//insert here - 메소드를 호출해 보세요. - E클래스에서 선언한 메소드 호출하기 - 누구를 인스턴스화 해야 하나요?
		E e = new E();
		System.out.println("첫번째 숫자를 입력하세요.");
		int first = e.getFirst();
		System.out.println("첫번째 입력받은 숫자는 " + first + " 입니다.");
		System.out.println("두번째 숫자를 입력하세요.");
		int second = e.getSecond(); //메소드 호출이다.
		System.out.println("두번째 입력받은 숫자는 " + second + " 입니다.");
		System.out.println("더하기를 할 숫자 2개를 입력하세요.");
		int add = e.add(first, second); //메소드 호출이다.
		System.out.println("두 수의 합은 " + add + " 입니다.");
		System.out.println("빼기를 할 숫자 2개를 입력하세요.");
		int minus = e.minus(first, second); //메소드 호출이다.
		System.out.println("두 수의 차는 " + minus + " 입니다.");
		System.out.println("곱하기를 할 숫자 2개를 입력하세요.");
		int multi = e.multi(first, second); //메소드 호출이다.
		System.out.println("곱셈을 할 숫자 2개는 " + multi + " 입니다.");
		System.out.println("나누기를 할 숫자 2개를 입력하세요.");
		double divide = e.divide(first, second); //메소드 호출이다.
		System.out.println("두 수의 나누기는 " + divide + " 입니다.");
	}//end of main

}//end of Emain
/*
	0~9사이 임의의 숫자를 채번하고
	사용자로부터 숫자를 입력받아
	입력받은 숫자가 더 작으면 '힌트를 높여라' 라고 출력하고
	더 크면 낮춰라 라고 힌트를 주어
	5번까지만 기회를 제공해서 그 숫자를 맞추는 게임을 작성해 보시오.
*/