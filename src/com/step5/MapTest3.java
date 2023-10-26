package com.step5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest3 {

	public static void main(String[] args) {
		List<Map<String, Object>> deptList = new ArrayList<>(); //10을 String이 아닌 int로 받아야 하므로. 여러 타입 받으려면 상위 클래스 Object로
		Map<String, Object> map = new HashMap<>();
		map.put("DEPTNO", 10); //DB연동할때 키 값 넣어줄 때 대문자로 넣어주기 때문에 대문자로 바꿔봤다~
		map.put("DNAME", "영업부");
		map.put("LOC", "부산");
		deptList.add(map);
		Set<String> set = map.keySet(); 
		Object keys[] = set.toArray();
		for(int i=0; i<keys.length; i++) { 
			System.out.println(keys[i]+ "===>" + map.get(keys[i]));
		}
		System.out.println(deptList.get(0).get("DEPTNO")); //10 //. 두 개 붙이는 거 까지 연습하자
		System.out.println(deptList.get(0).get("dname")); //null
		System.out.println(deptList.get(0).get("LOC"));
	}

}
