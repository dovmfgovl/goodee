package collec.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//소셜로그인 구현, 카카오 우편번호 검색, 카카오페이 도전 - Map에 집중해야 한다...!
public class KeyMain2 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();//컬렉션 프레임워크의 기본단위는 Object이기 때문에 wrapper클래스인 Integer가 와야함. int는 올 수 없음.
		map.put(new Integer(1), "85"); //autoboxsing 원시형 int Integer
		map.put(2, "75");
		map.put(3, "65");
		//String names[] = {"나신입", "나초보", "나일등"};
		Object names[] = null;
		//names.length
		//System.out.println(names.length); //NullPointerException
		Set<Integer> set = map.keySet();
		names = set.toArray();
		//위 두 코드를 하나로 합치기
		//메소드의 리턴타입이 오브젝트 일 수 있다.
		//변수명.메소드명().메소드명()
		Object[] its = map.keySet().toArray(); //한 줄로 묶어 쓸 수도 있어야 함...
		its = set.toArray();
		for(Object obj : its) {
			System.out.println(obj);
		}
		System.out.println("===================================");
		System.out.println(names.length); //수정 전..) ClassCastException - 타입이 맞지 않다는 의미
		for(int i=0; i<names.length; i++) {
			Integer key = (Integer)names[i];
			System.out.println(key);
		}
	}

}
