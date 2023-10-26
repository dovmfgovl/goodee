package com.step3;

public class Return3 {
	String m(int i ) {
		String hint = null;
		//조건에 따라서 return을 사용하게 되므로 못 만날수도 있다.
		//그래서 반드시 else추가해서 디폴트라도 넣어줘라.
		if(i < 0) { //너 음수니?
			return hint = "너 음수래";
		} else if(i > 0) { //너 양의 정수이다
			hint = "너 양수래";
			return hint;
		} else {
		return "";
		}
	}
	String m2(int i ) {
		String hint = null;
		if(i < 0) { //너 음수니?
			return hint = "너 음수래";
		} else if(i > 0) { //너 양의 정수이다
			hint = "너 양수래";
			return hint;
		} else {
		}
		return "";
	}
	public static void main(String[] args) {
		
	}

}
