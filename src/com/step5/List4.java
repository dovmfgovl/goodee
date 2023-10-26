package com.step5;

import java.util.ArrayList;
import java.util.List;
/////////////실전예제///////////////
public class List4 {
	//ArrayList는 List타입이다.
	List<DeptDTO> li = new ArrayList<>();//앞이 인터페이스, 뒤는 구현체 클래스(선언과 초기화 다르게) - 확장성, 유지보수할 때 코드 수정 양을 줄여줌 
	//스프링에서 JPA로 DB 연동을 할 땐 (-Hibernate 자동처리시(쿼리문이 없는데 DB연동됨 - 자바 클래스로 데이터셋 설계))
	//LIst<Map<String, Object>>로 한다. (특히 조인(둘 이상의 테이블 연결해서 조회 - 업무가 복잡할수록) 하는 업무 내용일 때 사용함)
	//다음으로 -> 쿠키(only String)와 세션(자료구조 섞어씀 - hard함) 
	public static void main(String[] args) {
		List4 l4 = new List4();
		DeptDTO dept = new DeptDTO(); //DeptDTO 클래스 인스턴스화) 아래 3개를 한 묶음으로 관리하고 싶어서
		dept.setDeptno(10); //dept집합 클래스는 3가지 정보 관리 위해 설계되었고 변수 3개 선언됨. 변수가 위변조 되는 것을 막기 위해 private
		dept.setDname("영업부");
		dept.setLoc("부산");
		l4.li.add(dept); //List에는 못 담고 ArrayList에 담은 것
		dept = new DeptDTO();
		dept.setDeptno(20);
		dept.setDname("개발부");
		dept.setLoc("대전");
		l4.li.add(dept);
		System.out.println(l4.li); // []
		DeptDTO rd = l4.li.get(0);
		System.out.println(rd.getDeptno()+ "," +rd.getDname()+ "," +rd.getLoc());
		rd = l4.li.get(1);
		System.out.println(rd.getDeptno()+ "," +rd.getDname()+ "," +rd.getLoc());
	}

}
