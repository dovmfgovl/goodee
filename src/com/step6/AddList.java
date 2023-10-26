package com.step6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.google.gson.Gson;
/*
 * 업무요청에 대한 결과가 조인이 불가피할 때 하나의 클래스로 제네릭을 사용할 수 없다. 
 * Map 인터페이스를 사용하는 것이 효과적임 - 키와 값으로 관리함
 * 키를 컬럼명으로 통일하면 일관성 있는 변수명으로 접근 가능함 - 속도도 빠름
 */
class Emp1{
	private int empno = 0;
	private String ename = null;
}
class Dept1{
	private String dname = null;
}
//컬렉션 프레임워크란? - 자료구조를 API로 구현한 것
//읽기와 쓰기 추가로 검색기능 지원
public class AddList {

	public static void main(String[] args) {
		JButton jbtnSelect = new JButton();
		//선언부와 생성부의 이름이 다르면 다형성을 누릴 수 있다.
		//다형성에 대한 전제조건이다.
		//인터페이스, 추상클래스 변수명 = new 구현체클래스();
		//재사용성을 높인다. 이식성을 좋게 함. 유연하다
		//기존 코드를 변경해애한다. - 있는 걸 바꾼다 - 사이드이펙트(부수효과) 발생함
		//이식성, 재사용성 - 객체지향 언어가 추구하는 방향성
		//전역변수 - 클래스 중심의 코딩 전개함 - 중요함 
			//- 유지됨 - 람다식과 같은 함수형에서는 사용하지 않는다 - 왜냐면 사이드이펙트 발생하니까
		//지역변수 -처리하면 그 메소드 안에서만 유지됨 - 사이드이펙트 발생하지 않음
			//- 안전함 - 람다식 - 함수형 프로그래밍 지원 가능한 이유
		//상속 받거나 구현체 클래스를 선언할 때 하위 클래스를 상속 받는 게 더 많은 변수와 메소드를 사용할 수 있다.
		List<JButton> li = new ArrayList<>();
		//List 인터페이스의 구현체 클래스가 ArrayList이다.
		//인터페이스는 단독으로 인스턴스화를 할 수 없다(List<> li = List<>(); 할 수 없음).
		//List는 row를 관리한다.
		//제네릭 타입에는 테이블 구조에서 컬럼에 해당하는 값을 관리한다.
		//VO패턴과 Map타입을 사용할 수 있는데 VO타입에는 타입이 정확해서 형전환이 필요없지만
		//Map은 객체타입으로 받기 때문에 그 값을 가지고 연산을 할 때는 형전환을 해야함(CastingException이 다수 발생가능함)
		//제네릭 타입에는 멀티 타입을 적을 수 없어서 2개 이상의 집합을 조인했을 경우 VO타입보다는 Map을 사용하는 것이 복잡도를 줄일 수 있다.
		List<Map<String, Object>> list = new ArrayList<>();// [] 형식 가짐(Gson, lib 데이터 수집, 형전환, 변환) - JSON
		Map<String, Object> map = new HashMap<>(); // {"deptno": 10, "dname": "BOSTON"..}
		map.put("empno", 7782);
		map.put("ename", "CLARK");
		map.put("dname", "ACCOUNTING");
		list.add(map);
		System.out.println(list);
		Gson g = new Gson();
		String temp = g.toJson(list);
		System.out.println(temp);
	}

}
