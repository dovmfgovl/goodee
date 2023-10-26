package com.step3;
//문제 - 1부터 10까지 세면서 홀수의 합을 구하시오.
public class For3 {

	public static void main(String[] args) {
		int i = 0;
		int hap = 0; //홀수의 합을 구해서 담기
		int hap1 = 0; //짝수의 합을 구해서 담기
		for(i = 1; i <= 10; i++) {
			//너(세는 변수명(i)) 홀수니?
			if(i % 2 == 1) { // 1 3 5 7 9
				System.out.println("홀수일때...");
				hap += i;
				System.out.println(hap); // 5번만 출력하기
			}//end of if
			else if(i % 2 == 0) {
				hap1  += i;
			}
			System.out.println(hap); // 10번이 출력됨
		}//end of for
		System.out.println("홀수의 최종 결과 값은 : " + hap);
		System.out.println("짝수의 최종 결과 값은 : " + hap1);
	}

}
