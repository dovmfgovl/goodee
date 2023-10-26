package collec.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import collec.list.CustomerVO;

class Map3{
	Map<String, List<Map<String, CustomerVO>>> map = new HashMap<>();
	Map3(){
		List<Map<String, CustomerVO>> list = new ArrayList<>();
		Map<String, CustomerVO> imap = new HashMap<>();
		CustomerVO cvo = new CustomerVO();
		cvo.setC_id(12);
		cvo.setC_name("토마토");
		cvo.setC_birthday("2000-05-11");
		imap.put("1", cvo);
		list.add(imap);
		map.put("other", list);
	}
}
public class MapMain3 {

	public static void main(String[] args) {
		Map3 m = new Map3();
		System.out.println(m.map.size());
		//m.map.get("1")은 무슨 타입입니까?
		System.out.println(m.map.get("1"));
		//m.map.get("outer")은 무슨 타입이지? - List
		System.out.println(m.map.get("outer"));//_____왜 널이 나오지...? 해결하자..
		System.out.println(m.map.get("outer") instanceof List);
		//m.map.get("outer").get(0)은 무슨 타입인가요? - Map
		System.out.println(m.map.get("outer").get(0) instanceof Map); //true
		System.out.println(m.map.get("outer").get(0).get("1") instanceof CustomerVO); //true
		System.out.println(m.map.get("outer").get(0).get("1").getC_id()); //12
		System.out.println(m.map.get("outer").get(0).get("1").getC_name()); //토마토
		System.out.println(m.map.get("outer").get(0).get("1").getC_birthday()); //2000-05-11
	}

}
