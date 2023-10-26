package bclass.step1;

import javax.swing.JButton;

public class EMain extends Object {
	@Override
	public String toString() {
		return "null";
	}

	public static void main(String[] args) {
		EMain em = new EMain();
		JButton jbtn = new JButton("조회");
		System.out.println(em);
		System.out.println(em.toString());
		System.out.println(jbtn); //오브젝트가 제공하는 toString메소드를 오버라이딩 하고 있기 때문에 주소번지가 나오지 않음.
	}

}
