package collec.list;

import java.util.ArrayList;
import java.util.List;

class List1{
	//아래 전역변수가 읽혀지는 순간은 인스턴스화 할 때이다. -> 생성자가 호출되면 그 때 비로소 읽힘
	//초기화 문제 -> 시점[타임라인 관계] -> 인터셉트: Spring F/W{때를 파고든다}할 수 있다(관여)
	List<Integer> nums = null; //선언만
	List1(){
		List<Integer> nums = new ArrayList<>(); //선언 빼고(타입을 적지 않았으니까) 생성하기
		//1)
		//nums = new ArrayList<>(); //선언 빼고(타입을 적지 않았으니까) 생성하기 //지역변수를 전역변수로 바꾸기
	}
}
public class ListMain1 {

	public static void main(String[] args) {
		List1 list1 = new List1();
		//list1은 Null이 아니다. - 위를 보면 알 수 있다.
		//list1.연산자 다음의 nums 변수는 전역변수이다. nums는 null이기 때문에 Sysout~(list1.nums.size());에서 널포인터익셉션 발생
		//<널포인터익센션이 발생하지 않게 하는 방법>
		//2)
		list1.nums = new ArrayList<>(); //이와 같은 방법은 전역변수일 때만 가능하다. 지역변수일 땐 불가함 - 지변일 땐 어떡하지? : 리턴타입으로 해결함
		System.out.println(list1.nums.size());
	}

}
