package collec.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
//전체조회, 상세조회
class List8{
	//원시형타입에서 참조형(XXXVO, Map)으로 제네릭을 바꾸었다.
	List<String> rank = new ArrayList<>();//rank.size()=0
	void init() {//전역변수의 선언된 깡통에 3가지 정보를 추가하기
		rank.add(0,"나신입");
		rank.add(1,"나초보");
		rank.add(2,"나일등");
	}
	//전역변수면 어차피 동기화가 된다. - 하나이다 - static
	//단, 최초에는 빈통이니까 3명의 명단을 출력하려면 init() 경유시킬 것 - 전처리 - 출력 전에 먼저 init()을 호출 할 것.
	void rankSelect() { //왜 리턴타입을 void로 바꾸는 건가요? - 전역변수니까
		System.out.println(rank);
	}
	//자료구조에 들어있는 값을 순회하는데 get(int) 메소드의 리턴타입이 Element인 것을
	//사용자 정의메소드를 구현하여 굳이 리턴타입을 boolean으로 바꿔본다.(if문 복습)
	//한 건 조회하기 -> 조건식이 필요하니 파라미터가 필요하고, 전체 조회일 땐 있는 거 모두 출력이니 파라미터 필요없다.
	boolean rankDetail(int index) {
		boolean isOk = false;
		String name = null;
		//insert here
		name = rank.get(index);
		if(name != null) {
			isOk = true;
		}
		return isOk;
	}
}
public class ListMain8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//화면을 그리진 않지만 화면이 갖는 효과는 누릴 수 있다.
		List8 l4 = new List8();
		l4.init();
		for(int i=0; i<l4.rank.size(); i++) {
			System.out.println("전체조회이면 1번을 입력하고 상세조회이면 2번을 입력하시오.");
			String value = sc.nextLine();
			if("1".equals(value)) {
				//나 전체 목록 볼거야
				l4.rankSelect();
				continue;
			}else if("2".equals(value)) {
				l4.rankDetail(i);
				continue;
			}			
		}
	}

}
