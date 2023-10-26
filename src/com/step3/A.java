package com.step3;

public class A {
	//%연산자는 어떤 수를 2로 나눈 나머지 값을 반환하는 연산자
	public static void main(String[] args) {
		if(5%2 == 1) {
			System.out.println("5는 홀수입니다.");
		}
		if(4%2 == 0) {
			System.out.println("4는 짝수입니다.");
		}
		if(1000%2 == 0) {
			System.out.println("1000은 짝수입니다.");
		}
	}

}
