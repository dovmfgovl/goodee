package com.week2;

import java.util.Random;

// 사용자 클래스와 자바제공 클래스 - 2개를 가지고 연습하시오.
// 사용자 클래스와 사용자 클래스(를 활용하는 게 앞으로의 목표~) - 2개를 선언해서 훈련하기
// 인스턴스화 이다 -> 클래스와 클래스 관계
// 업무를 나누어 준다. 나신입, 나초보 -> 업무를 분장함 -> 형상관리(버전관리) -> Git 도구 활용
// 단위 테스트(테스트 시나리오 필요) -> 통합 테스트
// 업무와 업무 사이의 관계 확인 -> 칼퇴
public class Random1 {

	public static void main(String[] args) {
		Random r = new Random(); //내가 정의한 클래스가 아니야 -> 그러므로 인스턴스화
		// 나는 두번째 메소드를 선택함(파라미터가 1개- 메소드 오버로딩)
		// 메소드 호출시 리턴타입이 있는 메소드라면 왼쪽에 대입연산자를 사용할 수 있다.
		for(int i = 0; i < 10; i++) {
			int s = r.nextInt(10); // 0.0~10.0 //(10)+1 -> 1부터..!
			System.out.println(s);
		}
	}

}
