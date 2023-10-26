package com.free;

import java.util.ArrayList;
import java.util.List;
//List 객체 추가, 검색, 삭제
public class ListExam {

	public static void main(String[] args) {
//		String s1 = null;//객체 추가~
		String s2 = null;
		String s3 = null;
		List<String> fruits = new ArrayList<>();
		fruits.add("딸기");
		boolean isOk = fruits.add("수박");
		System.out.println(isOk);
		fruits.add(1, "포도");
		String s1 = fruits.get(0);
		s2 = fruits.get(1);
		s3 = fruits.get(2);
		boolean is = fruits.contains(s3);//객체 검색
		System.out.println(is);
		System.out.println(s1 +", "+ s2 +", "+ s3);
		System.out.println(fruits);
		for(int i=0; i<fruits.size(); i++) {
			System.out.print(fruits.get(i));
		}
		System.out.println();
		String s4 = null;
		s4 = fruits.set(2, "참외"); //객체 교환
		for(String change: fruits) {
			System.out.println(change);
		}
		String s5 = fruits.remove(0); //객체 삭제
		System.out.println(fruits);
		System.out.println(s5);
	}

}
