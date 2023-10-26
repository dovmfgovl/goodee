package com.step5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest4 {

	public static void main(String[] args) {
		List<Map<String, Object>> deptList = new ArrayList<>(); 
		Map<String, Object> map = new HashMap<>();
		map.put("DEPTNO", 10); 
		map.put("DNAME", "영업부");
		deptList.add(map);
		map = null;
		map = new HashMap<>(); //복사본
		map.put("LOC", "부산"); //아이디가 부여됐다는건 JVM이 기억하고 있다. 그래서 deptList.add(map); 아래에 있어도 들어감
		deptList.add(map); //부산만 들어옴
		map = new HashMap<>(); //앞에 Map<String, Object>를 또 적는건 재정의다. 같은 이름을 중복선언할 수 없다. //위 add 위치가 위에 있지 않고 아래에 있으면 10은 저장 안되고 20만 나옴
		map.put("DEPTNO", 20); 
		map.put("DNAME", "개발부");
		map.put("LOC", "대구");
		deptList.add(map);
		System.out.println(deptList);		
	}

}
