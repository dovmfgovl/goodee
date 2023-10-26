package com.step5;

import java.util.ArrayList;

public class List2 {
////////////삭제////////////
	public static void main(String[] args) {
		ArrayList fruits = new ArrayList(); //딸기, 사과, 블루베리
		fruits.add("🍓");
		fruits.add(1, "🍎");
		fruits.add(1, "🫐");
		String r1 = (String)fruits.remove(1); //E는 오브젝트를 뜻함(557p표 )
		System.out.println(fruits); //["","",""]
		System.out.println(r1);
	}

}
