package com.week1;
//EmpSimulation2 마지막 문제에 대한 설계....내가
class E{
	int i = 5;
}

public class EmpSimulation3 {
	void setEmp(E e) {
		System.out.println(e.i);
	}
	public static void main(String[] args) {
		EmpSimulation3 es3 = new EmpSimulation3();
		E e = new E();
		es3.setEmp(e);
		System.out.println(e.i);
		
	}

}
