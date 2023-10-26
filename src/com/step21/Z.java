package com.step21;

public class Z {
	int i = 1;
	void m1() {
		Z z = new Z();
		System.out.println(z); // 여기서 출력되는 주소번지와 13번 주소번지 같다!!!
		System.out.println(z.i); //1 출력됨
		m2(z);
	}
	void m2(Z z) {
		//여기에서 6번에 생성된 주소번지를 굳이 사용하고 싶다. 어떡하지?
		//파라미터 자리에 참조형 타입의 변수를 넘기면 원본을 재사용할 수 있다. - 이 예제 결론!
		System.out.println(z);
	}
	public static void main(String[] args) {
		Z z = new Z();
		z.m1();
	}

}
