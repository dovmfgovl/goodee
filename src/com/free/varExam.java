package com.free;

public class varExam {
	int intValue = 1; //전역변수 //같은 변수명 사용 가능
	double doubleValue; //전역변수는 초기화 생략 가능
	/*디폴트값: int는 0, double은 0.0, boolean은 false*/
	static int intValue2 = 2; //정적변수 //정적변수는 클래스 급인 참조형타입으로 인스턴스화 없이 호출 가능 //싱글톤
	
	public void methodA() {
		int number = 5; //지역변수 //같은 변수명 사용 불가
		System.out.println("methodA가 출력됨");
	}

	public static void main(String[] args) {
		varExam value = new varExam(); //인스턴스화 //인스턴스 변수(value)를 통해 호출할 수 있는 건 '전역변수' 뿐		
		System.out.println(value.intValue); //1 출력
//		System.out.println(intValue); //오류. 인스턴스 변수 미사용으로
		System.out.println(intValue2); //2 출력. 정적변수는 인스턴스화 하지 않아도 가능
		value.methodA(); //methodA가 출력됨 출력
	}

}
