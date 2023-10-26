package com.step2;

class Param1{
	//전변은 초기화를 생략할 수 있다. -왜냐면 생성자가 대신 해줌
	int ival;//전역변수이다.- 디폴트값은 0이다. - 왜냐면 자바는 int의 디폴트값을 제공함
}

public class TestParam1 {
	//18번에서 생성된 객체를 참조하게 되었다. 10번 파라미터 p가...
	void effectParam(Param1 p) {//p = null;  -> p = new Param()
		//insert here - 여기에 p = new Param()을 추가한다면
		//결과는 어떻게 달라질까요? 아님 변화가 없는 건가요?
		p.ival = 100;
		System.out.println("sub ival ==> " + p.ival);		
	}
	public static void main(String[] args) {
		//
		Param1 p = new Param1();
		//
		p.ival = 500;
		TestParam1 tp = new TestParam1();//인스턴스화 라고 한다. - heap메모리에 자리함
		//insert here
		tp.effectParam(p);
		System.out.println("main ival ==> " + p.ival);
	}

}
