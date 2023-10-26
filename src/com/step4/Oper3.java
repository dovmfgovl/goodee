package com.step4;

public class Oper3 {

	public static void main(String[] args) {
		int i=1; // i = 1
		int j=i++;   // j = 1 - 왜냐하면 대입이 먼저니까 - 무조건 ++이 뒤에 있으면 나중에 증가시킴 - OCJP                   
		System.out.println(i);
		if((i>++j)&(i++==j)) { //i = 2 // (2 > 2) => false & (2 == 2) => true
			System.out.println("참일때");
		}else {
			System.out.println("거짓일때");
		}
		System.out.println(i + "," + j); //3, 2
		i+=j; // i = i + j
		System.out.println(i + "," + j); //5, 2
	}

}
