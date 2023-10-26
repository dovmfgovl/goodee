package com.step3;

public class Break1 {

	public static void main(String[] args) {
		for(int i = 2; i < 10; i++) {
			//if문에 return을 만나면 메소드 탈출하고
			//if문이 반복문 안에 있을 땐 break; 사용할 수 있다. - for문을 탈출함
			if(i == 6) break;
		}
		System.out.println("요기요");
	}

}
