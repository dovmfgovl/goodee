package com.step2;

import javax.swing.JFrame;

public class JFrame2 {

	public static void main(String[] args) {
		JFrame jf1 = new JFrame();
		jf1 = null;
		jf1 = new JFrame();
		jf1.setTitle("첫번째");
		jf1.setSize(300, 500);
		jf1.setSize(800, 500);
		jf1.setVisible(true);
	}

}
/*
	8번에서 생성됐는데 9번에서 다시 null로 초기화 했고
	10번에서 같은 변수이름으로 다시 생성했으므로 기존에 생성된 객체의 참조는 끊어지고
	새로운 객체 하나를 참조하고 있다.
	9번에서 10번으로 진행되는 순간, 자바의 가비지 컬렉터에 의해 
	8번은 candidate상태로 빠져 다시 사용할 수 없게 되었다.
*/
