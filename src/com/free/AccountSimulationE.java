package com.free;

class Account{
	int first;
	int second;
	
	public void plus() {
		System.out.println(first + second);
	}
}

public class AccountSimulationE {
	public static void main(String[] args) {
		Account account = new Account();
		account.plus();
	}
}
