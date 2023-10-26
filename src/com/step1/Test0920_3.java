package com.step1;

public class Test0920_3 {	
	
	public static void main(String[] args) {
		P p = new P();
		System.out.println(P.i); //1
		System.out.println(T0920.x); //1
		System.out.println(p.i); //1
		//System.out.println(P.j); //오류
		//System.out.println(p.j); //10
	}/////end of main
}///end of Test0920
/*
	static은 클래스 급(참조형 타입이라)이라서 인스턴스화 없이 호출 가능.
	9번에서 호출한 j는 static이 아니라서 클래스이름.j 로 호출 불가(JVM에서 제공되는 컨벤션(약속)임)
		->해결방법: 인스턴스화 하고 인스턴스변수.j로 호출
*/