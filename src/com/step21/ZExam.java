package com.step21;

public class ZExam {
	int i = 1;
	void m1() {
		ZExam z = new ZExam();
		System.out.println(z);
		m2(z);
	}
	void m2(ZExam z) {
		System.out.println(z);
	}
	public static void main(String[] args) {
		ZExam z = new ZExam();
		z.m1();
	}

}
