package com.step21;

import javax.swing.JFrame;

//이름은 같지만 서로 다른 메소드이다.
public class Frame1 {
	JFrame jf = new JFrame();
	void initDisplay() {
		jf.setSize(500, 400); //상수를 사용해서 별로야
		jf.setVisible(true); //true도 상수임  ---> 파라미터 자리를 이용해서 상수를 다르게 가져갈 수 있다.
	}
	//메소드의 파라미터 자리는 호출될 때 결정된다.
	void initDisplay(int width, int height) { //하나는 변수로 처리가 되지만 나머지(boolean)는 상수로 처리함.
		jf.setSize(width, height); 
		//상수를 사용했기 때문에 앱이라면 음악을 듣는 중에 전화가 들어오는 상황을 상상해보면
		//기능 구현이 어렵다(상수라서).
		jf.setVisible(true); 
		
	}
	void initDisplay(int width, int height, boolean isView) {
		jf.setSize(width, height);
		jf.setVisible(isView); 
		
	}
	public static void main(String[] args) {
		Frame1 f = new Frame1();
		f.initDisplay(500, 400, false); //값에 의한 호출이다. - 호출될 때 지역변수가 초기화가 된다.(중요!)
	}

}
