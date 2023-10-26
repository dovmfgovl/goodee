package com.week1;

public class DeptSimulation {

	public static void main(String[] args) {
		//타입은 Dept타입인데 주소번지는 서로 달라요. 그래서 그 안에 정의한 변수 이름은 같지만 호출했을 때 값은 달라짐.
		Dept dept = new Dept();
		dept.deptno = 10;
		dept.dname = "개발부";
		dept.loc = "서울";
		System.out.println(dept.deptno + "," +dept.dname + "," +dept.loc); //10출력
		System.out.println(dept); //@4e50df2e
		dept = new Dept();
		dept.deptno = 20;
		dept.dname = "운영부";
		dept.loc = "대전";		
		System.out.println(dept.deptno + "," +dept.dname + "," +dept.loc); //10출력
		System.out.println(dept); //@1d81eb93
		dept = new Dept();
		dept.deptno = 30;
		dept.dname = "기획";
		dept.loc = "대구";
		System.out.println(dept.deptno + "," +dept.dname + "," +dept.loc); //10출력
		System.out.println(dept); //@7291c18f
	}

}
/*
 	7번 라인만 선언임. 11번, 15번은 선언이 아님.
 	같은 이름의 변수이더라도 new를 사용해서 인스턴스화를 하면 새로운 객체가 만들어진다.
 	이때 변수가 3개가 정의되어 있으므로 Dept클래스 선언 시 주었던 초기값을 디폴트 값으로 기억하고 있다.
 */