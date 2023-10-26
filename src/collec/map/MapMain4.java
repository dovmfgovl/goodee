package collec.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import collec.list.CustomerVO;
//Map 삭제
class Map4{
	//다형성을 누릴 수 있다. - 다를 수 밖에 없다. 왜냐하면 Map 인터페이스니까
	Map<String, CustomerVO> map = new HashMap<>(); //Map은 인터페이스라서 구현체 클래스 HashMap으로
	Map4(){
		CustomerVO cvo = new CustomerVO();		
		cvo.setC_name("나신입");
		cvo.setC_id(10);
		cvo.setC_birthday("2005-09-11");
		map.put("1", cvo); //map.size() = 1
	}
	void mapDelete() {
		map.remove("1");
	}
}
public class MapMain4 {

	public static void main(String[] args) {
		Map4 m = new Map4();
		System.out.println(m.map); //삭제 전
		Set<Map.Entry<String, CustomerVO>> entrySet = m.map.entrySet();
		Iterator<Map.Entry<String, CustomerVO>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, CustomerVO> entry = entryIterator.next();
			String key = entry.getKey(); //String 타입임
			CustomerVO cvo = entry.getValue();
			System.out.println(key + ", " + cvo);
		}
		System.out.println("==================[[삭제 후]]================");
		//m.mapDelete(); //remove - 객체 하나씩 삭제
		m.map.clear(); //객체 전체 삭제
		System.out.println(m.map);
	}

}
