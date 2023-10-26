package com.step3;

import java.util.Scanner;

class MaxPrint{
	int max(int n1, int n2) { //max 메소드 선언 및 구현
		if(n1 > n2) {
			//웹개발에서 html페이지에 처리결과를 출력할 때 사용된다. - 기억해줘!
			//아래 문장은 반드시 실행되는 건 아니다. 조건에 따라서 실행될 수도 안 될 수도 있다.
			return n1;
		} else if (n1 < n2) {
			return n2;
		} else {
			return -1; //end of file의 의미
		}
		//return
	}//end of max
}
public class MaxPrintMain {

	public static void main(String[] args) {
		MaxPrint mp = new MaxPrint();
		Scanner sc = new Scanner(System.in); //한번만
		int user1 = 0;
		int user2 = 0;
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				//아래 코드가 단 한번만 실행되도록 코드를 수정하기
				user1 = sc.nextInt(); // 이 문장이 두 번 호출되므로 user1변수에만 값이 두 번 담기고 결과적으로 덮어쓰기가 되므로 하나의 값만 기억됨				
			} else if(i == 1) { //두번째 반복될때는 아래 코드가 실행됨
				user2 = sc.nextInt(); 				
			}
			System.out.println("user1 : " + user1 + ", user2 : " + user2); //user2: 0
			//아래 낱말 카드의 문제점에 대해서 설명하시오.
			//서로 다른 두 수를 입력받아서 크다 작다를 비교해야 하므로
			//메소드 호출 전에 두 수가 먼저 결정되어 있어야 함 - 그래서 for문 밖에서 max메소드를 호출해야 함.
			//mp.max(i, user);
		}
		System.out.println(user1 + ", " + user2);
		int big = mp.max(user1, user2);
		System.out.println("big ===> " + big);
	}
}
//문제를 맞히는 프로그램을 완성하기 - 두번째 학습목표
//for문 syntax와 활용하기
/*연습문제
2. 두 개의 정수 중에서 큰 숫자를 반환하는 max메소드를 구현하세요.
두 개의 정수를 입력 받고 큰 숫자를 출력합니다.

출력) 정수(두 개) : 5 8
        최대값 : 8
*/