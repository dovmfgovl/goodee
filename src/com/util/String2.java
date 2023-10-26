package com.util;
//String - 원본이 바뀌지 않는다. 
//같은 이름의 두 개의 객체를 생성해서 처리함 - 문제제기
public class String2 {

	public static void main(String[] args) {
		String sql = "SELECT deptno, ";
		//System.out.println(sql);
		sql += "danme, loc FROM dept";
		sql += "WHERE deptno = 30"; //sql 3개가 생성됨
		System.out.println(sql);
		String s = "hello";
		System.out.println(s.replace('e', 'o'));
		s = s.replace('e', 'o'); //이렇게 치환해야 바뀜
		System.out.println(s); //위 치환을 하지 않으면 hollo 가 아닌 -> hello가 출력 => 원본은 안 바뀜
		//따라서 String으로 쿼리문을 담지 않음
	}

}
