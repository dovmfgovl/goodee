package aquiz.step1;
//throws, throw
public class Quest27_1 {
	//static이 붙은 메소드는 인스턴스화 없이 호출이 가능하다
	//클래스에 대한 제어권이 개발자인 나에게 없다 - Spring 컨테이너가 대신 주입해준다.
	static void m() throws Exception{ //예외처리를 나를 호출할 곳에서 하시오. 네가 해 예외처리
		System.out.println(5/0);
	}
	public static void main(String[] args) {
		System.out.println("main");
		try {
			Quest27_1.m();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
