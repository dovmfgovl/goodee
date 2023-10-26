package com.step1;

public class Double4 {

	public static void main(String[] args) {
		int junsu1 = 70;
		int junsu2 = 85;
		int junsu3 = 90;
		int total = junsu1 + junsu2 + junsu3;
		//평균을 알고 싶어요. 어떡하지?
		double value = total/3.0;
		System.out.println(value);
		//정수는 실수에 담을 수 있다.
		double d  = 3.14;
		//int+double = double
		//int-double = double
		//int*double = double
		//int/double = double
		System.out.println(150.0/3);//원래 나누어 떨어짐
		System.out.println(151/3.0);//double
		System.out.println(152/3);//int
		d = 150.0/3;
		//괄호안에는 왼쪽 타입명을 적는다. 왜?
		total = (int)(150.0/3);
		total = 152/3;
	}

}
