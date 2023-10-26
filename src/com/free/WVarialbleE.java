package com.free;

class Cat{
	int leg = 4; //전역변수(파란색)
	public void  walking() {
		int leg = 6; //지역변수(파란색 아님)
		System.out.println(leg);
	}
}

public class WVarialbleE {
	public static void main(String[] args) {
		Cat myCat = new Cat();
		System.out.println(myCat.leg);
		myCat.walking();
	}
}
//4 출력
//6 출력
