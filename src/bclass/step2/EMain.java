package bclass.step2;
// EMain is a E
class E{
	E(){
		System.out.println("E()");
	}
	void m() {
		
	}
}

public class EMain extends E {
	EMain(){
		System.out.println("EMain()");
	}
	//@Override
	void m(int i) { //@Override를 없애면 메소드 오버라이드가 아닌 메소드 오버로딩으로 합법이 됨
		
	}

	public static void main(String[] args) {
		new EMain(); //EMain을 호출했지만 E가 먼저 호출됨(아빠, 상위클래스를)!
	}

}
