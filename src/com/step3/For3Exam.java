package com.step3;
//문제 - 1부터 10까지 세면서 홀수의 합을 구하시오.
public class For3Exam {

	public static void main(String[] args) {
		int i = 0;
		int oddPlus = 0;
		int evenPlus = 0;
		for(i = 1; i <= 100; i++) {
			if(i % 2 == 1) {
				oddPlus += i;
			} else if(i % 2 == 0) {
				evenPlus += i;
			}
			}
		System.out.println(oddPlus); //2500
		System.out.println(evenPlus); //2550
		}

}
