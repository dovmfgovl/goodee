package aquiz.step1;
//파라미터를 갖는 생성자가 하나라도 있으면 디폴트 생성자를 추가해주지 않는다.
//심지어 디폴트 생성자를 호출하는 것이 아님에도 에러가 발생함
//왜 파라미터가 없는 생성자를 호출하는 걸까? 전역변수를 스캔
//자손의 생성자가 호출될 때 파라미터가 있든 없든 무조건 부모는 디폴트 생성자를 호출한다.
//그런데 생성자가 하나라도 있으면 디폴트 생성자이지만 자동으로 추가해주지 않는다.
class Super {
	public int i = 0;
	public Super() {
		System.out.println("Super()");		
	}//////////////삽입해야
	public Super(String text) {
		System.out.println("Super(String)");
		i = 1;
	}
}

public class Sub extends Super {
	public Sub(String text) {/////////////빨간줄 없어짐
		System.out.println("Sub(String)");
		i = 2;
	}

	public static void main(String args[]) {
		Sub sub = new Sub("Hello");
		System.out.println(sub.i); //2
//		Super sub = new Sub("Hello");
//		System.out.println(sub.i);
	}
}
