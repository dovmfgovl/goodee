package com.step3;

public class B {

	public static void main(String[] args) {
		int i = 1;
		int j = 0;
		//if문 괄호 안에는 조건문이 온다. 참인지 거짓인지를 판별할 수 있는 문장이 와야 함
		//&는 그리고 라고 일고 두 조건을 모두 만족할 때만 true를 리턴한다.
		if(i % 5 == 0 & i % 7 == 0) { //5와 7의 공배수
			System.out.println("fizzbuzz");
		}
		if(i > 0 & j < 1) {
			System.out.println("둘 다 참이면...");	//출력
		}
		else {
			System.out.println("둘 중 하나라도 false이면...");
		}
	}

}
