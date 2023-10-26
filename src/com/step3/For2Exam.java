package com.step3;
//짝수인 값만 더해보시오.
public class For2Exam {

	public static void main(String[] args) {
		int i = 0;
		int hap = 0;
		for(i= 1; i <= 10; i++) {
			if(i%2 == 0) {
			hap += i;
			}
		}
		System.out.println(hap);
	}

}
