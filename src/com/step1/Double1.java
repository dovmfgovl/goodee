package com.step1;

public class Double1 {

	public static void main(String[] args) {
		int i = 1;
		//정수는 실수에 담을 수 있다.
		double d  = 2;
		d = i;
		//대입연산자 오른쪽에는 왼쪽에 온 타입보다 큰 타입은 불가함
		//i = d; //왜 에러지?(위가 답)
		System.out.println(i); //1
		System.out.println(d); //1 or 2
	}

}
