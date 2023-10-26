package com.step4;

public class UnitTest {

	public static void main(String[] args) {
		BaseballGame bbg = new BaseballGame();
		String hint = null;
		int cnt = 0;
		for(int i=0; i<3; i++) {
			hint = bbg.account(++cnt +"회차 : "+"25" + ++i);			
			System.out.println(hint); // 세 번 출력결과 보고 싶어요
		}
//		for(int i=0; i<10; i++) {
//			bbg.ranCom();
//			System.out.println(bbg.com[0] + "" + bbg.com[1] + "" + bbg.com[2]);
//		}
	}

}
