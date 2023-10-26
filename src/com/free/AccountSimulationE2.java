package com.free;

class Account2{
	
	public void plus1(double first, double second) {
		first = 1.1;
		second = 2.5;
		double result = first + second;
		System.out.println(result); // 3.6 출력(3.5가 아닌)
	}
	public void plus2(int first, int second) {
		int result = first + second;
		System.out.println(result); // 8 출력(3이 아닌)
		first = 1;
		second = 2;
	}
}

public class AccountSimulationE2 {
	public static void main(String[] args) {
		Account2 account = new Account2();
		account.plus1(1.5, 2.0);
		account.plus2(3, 5);
	}
}
