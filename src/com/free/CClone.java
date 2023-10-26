package com.free;

public class CClone {
	int x;
	
	public static void methodA() {
		int x = 5;
		System.out.println(x);
		
		CClone c = new CClone();
		System.out.println(c.x);
	}
	public void methodB() {
		int x = 5;
		System.out.println(this.x);
	}

	public static void main(String[] args) {
		CClone.methodA();
		CClone c = new CClone();
		c.methodB();
	}

}
