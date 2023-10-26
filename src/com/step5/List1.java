package com.step5;

import java.util.ArrayList;

public class List1 {
//////////추가//////////////add///////////
	public static void main(String[] args) {
		String s1 = null;
		String s2 = null;
		String s3 = null;
		ArrayList<String> fruits = new ArrayList<String>();
		boolean isOk = fruits.add("🍓");
		System.out.println(isOk);
		s1 = fruits.get(0); //치환 (!!연습 많이 하기!!!!) //< >제네릭 쓰면 String 치환 안 해도 됨
		fruits.add(1, "🍎");
		s2 = (String)fruits.get(1); 
		fruits.add(1, "🫐"); //끼워넣기 가능(배열과 달리). 인터셉트 당할 수 있다.
		s3 = (String)fruits.get(2);
//		System.out.println(fruits.get(0)); //딸기
//		System.out.println(fruits.get(1)); //사과 //띄워쓰기 안 됨. 0 다음은 1로 차례대로 적어야 함. 0 다음 2로 적으면 에러뜸
		for(int i=0; i<fruits.size(); i++) {
			System.out.println(fruits.get(i)); //딸기, 블루베리, 사과
		}
		System.out.println(s1 +", "+s2+", "+s3);
	}

}
