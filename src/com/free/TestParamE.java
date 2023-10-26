package com.free;

class Param{
	int val;
}

public class TestParamE {
	void effectParam(Param p) {
		p.val = 100;
		System.out.println(p.val);
	}

	public static void main(String[] args) {
		Param p =  new Param();
		p.val = 10;
		TestParamE tpe = new TestParamE();
		tpe.effectParam(p);
		System.out.println(p.val);
	}

}
