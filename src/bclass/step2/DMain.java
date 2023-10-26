package bclass.step2;

import javax.swing.JFrame;

public class DMain extends JFrame {
	JFrame jf = new DMain();
	DMain(){
	}
	public void initDisplay() {
		//this는 DMain이다.
		//상위클래스(아빠)를 가리킬 때는 super
//		super.setSize(600, 500); //java.awt.Window
//		this.setVisible(true);
		System.out.println(jf);
		System.out.println(this);
		jf.setSize(600, 500); //java.awt.Window
		jf.setVisible(true);
		
	}
	public static void main(String[] args) {
		DMain dm = new DMain();
		dm.initDisplay();
	}

}
