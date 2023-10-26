package aquiz.step1;
//지역변수는 초기화를 생략할 수 없다.
public class Quest27 {
	//더 넓은 타입이 위에 오면 더 좁은 타입의 Exception은 컴파일 에러다.
	//try..catch 블록이 멀티로 작성 가능한데 더 좁은 타입(하위클래스)부터 더 넓은 타입(상위클래스)으로 작성할 것
	public static void parse(String str) {
		float f = 5.0f;
		int y = 2;
		int z = 0;
		try {
			f = Float.parseFloat(str);
			int x = y/z; //유효성 검사, 유효성 체크
			System.out.println(x);
		} catch (NumberFormatException nfe) {
			f = 0; // 에러 : 데이터형이 선언되지 않았다. F변수는 try절 안에서만 선언되어 있다.
		} catch (ArithmeticException ae) {
			System.out.println("[ArithmeticException] " + ae.toString());
		} catch (Exception e) {
			System.out.println("[Exception] " + e.toString());
		} finally {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		Quest27.parse("5"); //메소드
	}
}
