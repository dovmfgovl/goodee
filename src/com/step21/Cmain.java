package com.step21;
//C클래스는 데이터를 관리하는 클래스로 선언해 보았다.
class C{
	int n1 = 70;
	int n2 = 80;
	int n3 = 90;
}
//C1클래스에서는 C클래서에서 전달 받은 데이터를 가지고 총합을 구하는 메소드를 선언하였다.
//그런데 같은 이름의 메소드를 2개 정의함 - 메소드 오버로딩: 파라미터 갯수나 타입이 달라야 함.
class C1{
	int hap1() { //hap1메소드 안에서 데이터를 갖는 C클래스를 인스턴스화 하였다. - main없음
		//학생 수가 10명이라면 인스턴스화를 10번 반복해야함 - for문이나 while문 반복문 공부!
		C c = new C(); //데이터를 쥐고 있는 클래스를 지변으로 인스턴스화 하였다.
		int hap = c.n1 + c.n2 + c.n3;
		return hap;
	}
	int hap1(C c ) { //파라미터 자리에 c는 24번에서 생성된 객체를 참조함.
		int hap = c.n1 + c.n2 + c.n3;
		return hap;
	}	
}
public class Cmain {
	public static void main(String[] args) {
		C c = new C();
		C1 a = new C1();
		int hap = a.hap1();
		System.out.println(hap);
		c.n1 = 50;
		c.n2 = 60;
		c.n3 = 50;
		hap = a.hap1(c); //지역변수로 선언된 변수를 다른 메소드에서 사용함
		System.out.println(hap);
	}

}