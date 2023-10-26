package collec.map;

import java.util.HashMap;
import java.util.Map;
//나중엔 Spring Boot F/W로 사용함..다형성....
class Map1{
	//다형성을 누릴 수 있다. - 다를 수 밖에 없다. 왜냐하면 Map 인터페이스니까
	Map<String, Object> map = new HashMap<>(); //Map은 인터페이스라서 구현체 클래스 HashMap으로
	Map1(){
		System.out.println(map.size()); //원본본의 수 - 0이다. 아래 코드를 실행하고 나면 1로 바뀐다.
		map.put("1", 1); //map.size() = 1
		System.out.println(map.size()); //원본의 수 - 1이다.
		System.out.println(map); //{1=1} -> JSON에서는 {"1":1 "c_anme":"나신입"}으로 표기됨 - Map 구조이다. -> JavaScript로 꺼낸다.
		System.out.println(map.containsKey("1")); //true
		System.out.println(map.containsKey("2")); //false
		//JSON 포맷에서 [{}, {}, {},,, label: [{}, {}, {},,,]]
	}
	Map1(int i){
		map = new HashMap<>(); //새로운 객체를 생성함 - 복제본(원본인지 복제본인지 늘 고민..!)
		System.out.println(map.size()); //복제본의 수 - 0이다.
		//map.size() = 0 (-> 9번을 경유하지 않았으니까) map을 복제하고 put을 호출하지 않았으므로 0
	}
}
public class MapMain1 {

	public static void main(String[] args) {
		Map1 m1 = new Map1(); //전역변수가 읽혀진다. - 디폴트 생성자가 호출되었으니 출력이 될거야
		//insert here - 키 값이 1인 값을 출력하시오. - 인스턴스 변수 2번 오는 코드 확실하게 해둘 것
		System.out.println(m1.map.get("1"));
		Map1 m2 = new Map1(50000); //15번 생성자에서 50000을 사용하고 있지 않으므로 어떤 값을 치환해도 의미없다. 생성자를 호출하기 위한 값을 넣었을 뿐...
	}

}
