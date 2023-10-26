package com.step3;
public class For4 {

	public static void main(String[] args) {
		int i = 0;
		int hap = 0;
		for(i = 1; i <= 10; i++) {
			//너 3의 배수니?
			if(i % 3 == 0) { 
				hap += i;
			}//end of if
		}//end of for
		System.out.println("1부터 10까지 세면서 3의 배수의 합은? " + hap);
	}//end of main

}
