package collec.basic;

import java.util.ArrayList;
import java.util.List;

class B{
	List<Integer> nums = new ArrayList<>();
	int ival;
	String s = null;
	String s1 = new String(); 
	B(){
	}
	B(int ival){
		s = new String("나초보");
	}
}
public class BMain {
	
	public static void main(String[] args) {
		System.out.println("main호출");
		B b = new B();
		try {
			System.out.println(b.s.length());			
		} catch (Exception e) {
			System.out.println("NullPointerException 발동 - 왜냐하면 11번 디폴트 생성자에서는 s에 대한 인스턴스화가 안 됨");
		}
		b = new B(1);
		System.out.println(b.s.length()); //나초보 문자열 길이 3 출력됨
	}

}
