package collec.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//소셜로그인 구현, 카카오 우편번호 검색, 카카오페이 도전 - Map에 집중해야 한다...!
public class KeyMain {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("나신입", 85);
		map.put("나초보", 75);
		map.put("나일등", 65);
		//String names[] = {"나신입", "나초보", "나일등"};
		Object names[] = null;
		//names.length
		//System.out.println(names.length); //NullPointerException
		Set<String> set = map.keySet();
		names = set.toArray();
		System.out.println(names.length); //수정 전..) ClassCastException - 타입이 맞지 않다는 의미
		for(int i=0; i<names.length; i++) {
			String key = (String)names[i];
			System.out.println(key);
		}
	}

}
