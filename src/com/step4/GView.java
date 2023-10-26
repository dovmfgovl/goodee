package com.step4;
//아래 코딩 상황을 그림으로 그려본다.
//GLigic에서 GView의 j를 사용하고 싶다 어떡하지?
//GView에서 GLogic의 i를 사용하고 싶다 어떻게?
//사용자정의 클래스와 자바제공 클래스 사이에 활용하기 가능한가?
class GLogic{
	int i = 1;
	GLogic(GView gv){ //gv = null
		System.out.println("GLogic : " + gv);
		System.out.println("GLogic : " + gv.j);
	}
}
public class GView {
	int j = 1;
	GView(){
	//디폴트생성자만 생략가능함. - 2번 경유한다.
	GLogic gl = new GLogic(this); //this는 현재 스레드가 관리하는 클래스이고 원본임.
	}
	public static void main(String[] args) {
		//static 안에서는 this나 super사용불가 - 생성자에서는 가능함
		//gv = new GView();가 추가됐을 때, this는 앞에건가? 뒤에건가?
		GView gv = new GView(); //여기 주소번지와
		gv = new GView(); //여기 주소번지가 다르다
		gv.j = 10; //서로 다른 값을 가질 수 있다. -이중적이다. - 좋지않다(이런 식의 연습은 할 필요없다) - 절대 방어하려면 -> static으로 하던가, 싱글톤으로 처리하시오. - 메모리 누수
		System.out.println(gv);
		System.out.println(gv.j);
	}

}
