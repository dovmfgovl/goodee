package collec.list;

import java.util.ArrayList;
import java.util.List;
//html의 태그 쪼개기 버전이 리액트이다. 
class List2{
	List<Integer> li = new ArrayList<>();
	List<String> names = null;
	boolean isOk = false;
	List2(){
		//insert here - names를 인스턴스화 하는 문장을 작성하시오.
		names = new ArrayList<>();
		//같은 이름(기능)의 메소드라 하더라도
		//add(int, element): void - 리턴타입이 void라서 대입연산자로 받을 수 없다.
		//API에서 제공되는 메소드 중에서 처리 결과를 받을 수 있는 메소드가 있다. - boolean
		//if(isOk) System.out.println("처리 성공"); else System.out.println("처리 실패");
		//insert here - li에 숫자 1을 담는 코드를 작성하시오. - boolean isOk = add(Object obj)
		//논리 에러를 찾는 건 어렵다(조건문과 반복문 섞어쓰기) - 런타임 에러이다. - 디버깅 어렵다.
		//html과 Java(List와 Map -> JSON으로 뽑고 그 데이터셋을 <td>나신입{자바자리 - Map, XXXVO}</td> 섞어쓰기
		boolean isOk = li.add(1); //li.size()=1, List의 기호는 [1] - Front-End와 Back-End 만나는 부분 처리(List(로우가 여러 개) - [], Map(컬럼의 종류)- {})
		//아래 코드에 대해 정확히 설명해보시오.
		this.isOk = isOk;
		System.out.println("isOk가 true이면 데이터 추가를 성공했다는 것이다."); //사용자(업무 담당자)에 대한 응답처리의 기준 값으로 사용됨
		//사용자 정의 메소드를 구현할 때 리턴타입에 대해서 신중하게 결정해야한다.
		names.add("나신입"); //API : set은 덮어쓰기 , add는 기존 값 유지되고 뒤에 추가됨
		//아래 코드는 인스턴스화 없이도 출력 가능함 - 왜냐하면 내 안에 정의된 전역변수이니까
		System.out.println(names);
		//아래 코드가 실행되면 나신입이 나초보로 덮어씌어진다. - 외부에서는 이전 정보를 출력할 수 없다.(위치문제)
		Object obj = names.set(0, "나초보"); //add로 하면 size - 2, set으로 하면 size가 늘 1이다.
	}
}
public class ListMain2 {

	public static void main(String[] args) {
		//insert here - [1]을 출력하는 문장을 적으시오.
		List2 li2 = new List2();
		System.out.println(li2.li); //[1] - 생성자를 경유하니까 19번을 만났다.
		//insert here - [나신입]을 출력하는 문장을 적으시오.
		System.out.println(li2.names);
		//19번 라인에서 처리된 결과를 여기(ListMain2)에서 확인받고 싶다. 어떡하지? - isOk가 지변이네 -> 전변으로 해결하기 -> 초기화 필요
		//22번에서 전역변수의 초기화를 다시 하면 한 번 생성된 인스턴스 변수에 대해서 isOk 값은 하나의 값만 가진다. (유지의 문제 - 쿠키, 세션에서 아주 중요)
		System.out.println(li2.isOk); //true 출력 -> li2.size() 했을 때 1이 출력되면 확인된 것이다. 
	}

}
