package com.free;

public class DeptSimulationE {

	public static void main(String[] args) {
		DeptE de = new DeptE();
		de.setDname("가나다");
		System.out.println(de.getDname());
		de.setDnumber(84);
		System.out.println(de.getDnumber());
		
		String name = "가나다";
		de.setDname(name);
		System.out.println(de.getDname());
		
		String loca = "서울";
		de.setLoc(loca);
		System.out.println(de.getLoc());
	}

}
