package com.step21;

import java.util.Random;
import java.util.Scanner;

class E1 {
	Scanner sc = new Scanner(System.in); 
	public int number() {
		Random r = new Random();
		int dap = r.nextInt(10); //0.0~10.0인데 0.0은 포함하고 10.0은 포함하지 않는 그 사이의 정수값이 채번됨.
		dap = sc.nextInt();
		for(int i = 0; i < 10; i++) {
			if( i < dap ) {
				System.out.println("높여라");
			} else if( i < dap){
				System.out.println("낮춰라");
			} else {
				System.out.println("정답");
			}
		}
		return dap;
	}
}
public class Emain1 {
	public static void main(String[] args) {
		E1 e1 = new E1();
		System.out.println("0~9 중 첫번째 숫자를 입력하세요.");
		e1.number();
	
	}//end of main

}//end of Emain
/*
	0~9사이 임의의 숫자를 채번하고
	사용자로부터 숫자를 입력받아
	입력받은 숫자가 더 작으면 '힌트를 높여라' 라고 출력하고
	더 크면 낮춰라 라고 힌트를 주어
	5번까지만 기회를 제공해서 그 숫자를 맞추는 게임을 작성해 보시오.
*/