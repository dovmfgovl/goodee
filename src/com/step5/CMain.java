package com.step5;
class C{
	int i;
	C getInstance() { //Calendar cal = Calendar.getInstance(); //싱글톤 패턴
		return new C();
	}
}
public class CMain {

	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.i); //0
		System.out.println(c);
		c.i = 10; //재정의
		System.out.println(c.i);
		//위의 c와 getInstance() 리턴 타입으로 받는 c는 서로 다른 걸 가리킨다.
		System.out.println(c.getInstance().i); //0 - 재정의 해도 값이 안바뀜. 복사본이다.
		System.out.println(c.getInstance());
		c = new C();
		System.out.println(c);
	}

}
