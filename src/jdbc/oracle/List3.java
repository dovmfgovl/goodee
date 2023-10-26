package jdbc.oracle;
/*
 * List의 제네릭 타입으로 VO를 선택할 것인가? 아니면 Map을 선택하는 것이 맞는걸까?
 * 기준이 뭐야?
 * 관찰 - 생각, 고민
 * BookVO - 타입이 정해져있다. - 값(원시형과 참조형)을 담는다
 * 
 *  Map<String, Object> - 키(VO에서 변수명이고, 오라클에서는 컬럼명이다)와 값(추상적이다. - Object - 결정 안 됨, 미정, 다 된다)
 *  문제제기 )
 *  서로 다른 키가 참조하는 값으로 연산을 해야 한다면? 어떤 점을 고려해야 하나요? -> 타입이 문제 되지 않는걸까?
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List3 {
	void methodA(List<BookVO> bookList) {
		// 사용권 - 나신입 - 로그인 - 권한
		//bookList.size() = 0
		System.out.println(bookList);
		BookVO rbVO = bookList.get(0);
		System.out.println((Integer)rbVO.getB_price() instanceof Integer);
		System.out.println("10"+10); //1010
		//CastingException, NumberFormatException...
		System.out.println(rbVO.getB_price()*5); //곱하기 됨
	}
	void methodB(List<Map<String, Object>> bookList) {
		//bookList.size() = 0
		System.out.println(bookList);
		Map<String, Object> rmap = bookList.get(0);
		System.out.println(rmap.get("b_price") instanceof Integer);
		System.out.println(rmap.get("b_price") instanceof String);
		System.out.println(rmap.get("b_price") instanceof Object);
		System.out.println(rmap.get("b_price")*5); //타입이 Object라 곱하기 안됨
	}
	public static void main(String[] args) {
		List3 li3 = new List3();
		List<BookVO> bookList = new ArrayList<>();
		BookVO bVO = new BookVO(); //b_no, b_title, b_author, b_price -> private - thread가 관리함. List<ChatServerThread>
		//bVO.getB_no() -> 0, _title() -> "", author() -> null, price() -> 0
		bVO.setB_no(1);
		bVO.setB_title("자바의정석");
		bVO.setB_author("남궁성");
		bVO.setB_price(30000);
		//# 뭐가 담겼지? BookVO 주소번지가 하나 담겼다. BookVO 안에는 변수가 4개 선언되어 있다.
		// 4개 중에서 2개는 int, 2개는 String - 관찰하기
		bookList.add(bVO);// bookList.size() = 1 - 뭐가 하나지? :bookVO가
		List<Map<String, Object>> bookMap = new ArrayList<>();
		//bookMap.add(bVO); //제네릭 타입이 달라서 컴파일 에러 발생함
		Map<String, Object> map = new HashMap<>();
//		map.put(0, 1);
//		map.put("b_no", 1+3);
		map.put("b_no", 1);
		map.put("b_title", "자바의정석");
		map.put("b_author", "남궁성");
		map.put("b_price", 30000);
		bookMap.add(map); //빈깡통이다.
		li3.methodA(bookList);
		li3.methodB(bookMap);
	}

}
