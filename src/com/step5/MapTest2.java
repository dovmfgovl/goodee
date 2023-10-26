package com.step5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest2 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("deptno", "10"); 
		map.put("dname", "영업부");
		map.put("loc", "부산");
		Set<String> set = map.keySet(); //위 타입과 맞춰줘야 하므로 <String>
		Object keys[] = set.toArray();
//		System.out.println(keys[0]);// Map은 순서없으니 값도 랜덤으로 출력됨
//		System.out.println(keys[1]);
//		System.out.println(keys[2]);
//		System.out.println(keys[3]); //ArrayIndexOutOfBoundsException - 값 없으니까
		for(int i=0; i<keys.length; i++) { //Map에서 length는 column을 뜻함(키 니까)
			//System.out.println(i);
			System.out.println(keys[i]+ "===>" + map.get(keys[i]));
		}
	}

}
