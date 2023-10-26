package collec.map;

import java.util.HashMap;
import java.util.Map;

import collec.list.CustomerVO;
//나중엔 Spring Boot F/W로 사용함..다형성....
class Map2{
	//다형성을 누릴 수 있다. - 다를 수 밖에 없다. 왜냐하면 Map 인터페이스니까
	Map<String, CustomerVO> map = new HashMap<>(); //Map은 인터페이스라서 구현체 클래스 HashMap으로
	Map2(){
		System.out.println(map.size()); //원본본의 수 - 0
		//insert here
		CustomerVO cvo = new CustomerVO();		
		cvo.setC_name("나신입");
		cvo.setC_id(10);
		cvo.setC_birthday("2005-09-11");
		map.put("1", cvo); //map.size() = 1
		System.out.println(map.size()); //원본의 수 - 1이다.
		//map 안에 키가 "1"인 값은 CustomerVO 타입이다. 
		//이것을 증명할 수 있는 낱말카드를 나는 작성할 수 있다 | 없다. 
		
//		System.out.println(map); //{1=1} -> JSON에서는 {"1":1 "c_anme":"나신입"}으로 표기됨 - Map 구조이다. -> JavaScript로 꺼낸다.
//		System.out.println(map.containsKey("1")); //true
//		System.out.println(map.containsKey("2")); //false
		//JSON 포맷에서 [{}, {}, {},,, label: [{}, {}, {},,,]]
	}
}
public class MapMain2 {

	public static void main(String[] args) {
		System.out.println("main");
		Map2 m = new Map2();
		CustomerVO cvo = m.map.get("1");
		System.out.println(cvo); //여기서 출력되는 주소번지와
		System.out.println(m.map.get("1")); //아래에서 출력되는 주소번지가 같니
		System.out.println(cvo.getC_name());
		System.out.println(m.map.get("1").getC_name());
		System.out.println(m.map.get("1").getC_id()); //10
		System.out.println(m.map.get("1").getC_birthday()); //2005-09-11
		System.out.println(cvo.getC_name().equals(m.map.get("1").getC_name()));
		System.out.println(cvo instanceof CustomerVO);
		System.out.println(m.map.get("1") instanceof CustomerVO);
		//위) 화면 솔루션과 자바 연동할 때 - 이종 간 연계할 때 instanceof 많이 사용함 - 공통코드로 사용했던 부분
	}

}
