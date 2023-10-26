package com.week1;
//EmpSimulation2 마지막 문제에 대한 설계....선생님
class C{
	int i = 1;
} //end of C
public class CSimulation {
	void methodA(C c) {
		System.out.println("methodA ===> " + c.i);
	}

	public static void main(String[] args) {
		CSimulation cs = new CSimulation();
		C c = new C();
		cs.methodA(c);
		System.out.println("main ===> " + c.i);
	} //end of main

} //end of CSimulation
