package collec.basic;

import java.util.ArrayList;
import java.util.List;

//int -> wrapper클래스 이름 Integer(변수와 메소드를 소유할 수 있다)
//인스턴스화 -> 클래스 -> 추상클래스와 인터페이스 -> 생성자 호출 -> 파라미터 자리(변수)
class A{
	List<Integer> nums = new ArrayList<>();
	int ival;
	String s = null;
	String s1 = new String(); //전역변수가 사용되는 건 생성자가 호출됐을 때!
	//같은 이름의 생성자를 여러 개 갖는다 - 메소드 오버로딩 : 파라미터 타입이나 갯수가 달라야 한다.
	A(){
		s = new String("나신입");
		System.out.println(s);
	}
	A(int ival){
		A a = new A();
		s = new String("나초보");
	}
	A(String name){
		s = new String(name);
	}
}
public class AMain {
	
	public static void main(String[] args) {
		System.out.println("main호출"); //A클래스의 전역변수들은 읽혀졌을까? 아니 -> 인스턴스화(A)
		String s=  null;
		//1)
		A a = new A();
		System.out.println(a.s); //나신입을 출력
		//2)
		a = new A(0);
		a.s = "나신입";
		System.out.println(a.s);
		a = new A(0);
		//생성자의 파라미터 자리(메소드 오버로딩)를 활용하여 문제를 해결해보세요.
		// 3)
		a =new A("나신입");
		//4)
		s = "나신입";
		a = new A(s);
		System.out.println(s);
		
		//System.out.println(s.length()); //NullPointerException --- 'invoke'
	}

}
