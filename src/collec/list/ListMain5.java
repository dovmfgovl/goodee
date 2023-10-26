package collec.list;
/*
 * 제네릭을 VO나 Map으로 선택하는 건 JSON 형식의 사전 준비 작업이다.
 * 공공포털이나 회사들이 자신들의 서버를 공개하지 않는 대신 요청에 대한 검색 결과를 JSON으로 제공한다.
 * List<VO> -> JSON, JSON -> List<VO>, List<Map>으로 바꿔 쓸 수 있다.
 * 입력 - add(element): boolean -> 응답처리 시 선택, add(int, element) :  void -> 응답처리 시 부적합
 * 			리턴타입이 boolean이라서 처리 결과에 대한 응답을 받아 볼 수 있따(보이지 않는 걸 확인해줌)
 * 			메소드 선택 시 기준이 될 수 있다 - 리턴타입이 있고 없고가 기준에 영향 끼침.
 * 			: 사용자 정의 메소드를 설계할 때 리턴타입을 반드시 고려하시오. - 안전한 코드를 작성하기 위해.
 * 			제네릭을 반드시 정한다 - 직관적이다 - 직관적이지 않으면 담는 사람도 꺼내는 사람도 기억할 수 없다.
 * 			그런데 서비스는 기억(알림설정, 메시지 푸쉬)해준다.
 * 수정 - set(int, element): Element(=Object) : 내가 추가한 것을 그대로 반환해준다.
 * 상세보기
 * 전체보기
 * 삭제
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
//수정
class List5{
	//원시형타입에서 참조형(XXXVO, Map)으로 제네릭을 바꾸었다.
	List<String> rank = new ArrayList<>(); //rank.size() = 0
	void init() { //전역변수에 선언된 깡통에 3가지 정보 추가하기
		rank.add(0, "나신입");
		rank.add(1, "나초보");
		rank.add(2, "나일등");
	}
	boolean rankUpdate(int index, String newValue) {
		boolean isOk = false;
		boolean isEqual = false;
		//oldValue: 기존에 들어있던 값을 담는 변수 선언
		//newValue : 새로 들어갈 값을 담을 변수(사용자가 입력한 이름으로 담음)
//		String oldValue = rank.set(index, newValue);
//		System.out.println(oldValue + ", " + newValue);
//		System.out.println(oldValue == newValue);
//		System.out.println(oldValue.equals(newValue));
		//문제 - 기존 값과 같은 값이면 수정 처리 하지 않도록 코드를 수정하시오.
		for(int i=0; i<rank.size(); i++) {
			//사용자가 입력한 인덱스의 위치값과 rank 리스트의 인덱스 값이 같으면 그 자리가 변경할 위치이다.
			if(i == index) {
				String oldValue = rank.get(index); //그때 그 위치값이 우리가 비교할 기존 이름 값이다.
				if(oldValue.equals(newValue)) {
					isEqual = true;
				}
			}
		}
			if(isEqual) {
				System.out.println("기존 이름과 같은 이름을 입력하셨습니다. 다시 입력하세요.");
				return false;
			}else {
				System.out.println("기존 이름과 다른 이름을 입력하셨습니다. 수정을 진행합니다.");
				String oldValue = rank.set(index, newValue);
				isOk = true;				
			}
		return isOk;
	}
}
public class ListMain5 {

	public static void main(String[] args) {
		System.out.println("수정하고자 하는 위치값과 이름을 입력하시오. 예) 위치값|변경할값");
		Scanner sc = new Scanner(System.in); //화면을 그리진 않지만 화면이 갖는 효과는 누릴 수 있다.
		// 2|5 -> index=2; value=5
		String user = sc.nextLine();
		StringTokenizer st = new StringTokenizer(user, "|");
		String imsi = st.nextToken();
		int index = Integer.parseInt(imsi); //String -> int 바꿔줘(기능, 처리, 메소드힘)
		String value = st.nextToken();
		List5 l4 = new List5();
		l4.init();
		boolean isOk = l4.rankUpdate(index, value);
		if(isOk) {
			System.out.println("수정 처리되었습니다.");
			System.out.println(l4.rank); //[1,2,3] -> 1|3 -> [1,3,3]
		}else {
			System.out.println("수정 실패하였습니다.");
		}
	}

}
