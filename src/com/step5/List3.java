package com.step5;

import java.util.ArrayList;
//////////////////검색///////////////////
public class List3 {
	void getFruitList(ArrayList<String> fruits) {
		for(int i = 0; i<fruits.size(); i++) { //자료구조는 length말고 size 사용
			System.out.println(fruits.get(i)); // 0 1 2
		}
	}
	ArrayList<String> methodA(){
		ArrayList<String> fruits = new ArrayList<String>(); //딸기, 사과, 블루베리 //생성부의 제네릭 타입은 생략할 수 있다. 단 < > 다이아연산자만 남겨주면 됨
		fruits.add("🍓");
		fruits.add(1, "🍎");
		fruits.add(1, "🫐");
		return fruits;
	}
	public static void main(String[] args) {
		List3 li = new List3();
		ArrayList<String> fruits = li.methodA();
		System.out.println(fruits); // ["","",""] -> Map에선 { }로 찍힘

	}

}
