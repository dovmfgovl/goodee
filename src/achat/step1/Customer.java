package achat.step1;

import javax.swing.JFrame;
//p. 524 Runnable에 대한 예제  + p.528
public class Customer extends JFrame implements Runnable{

	public static void main(String[] args) {
		Customer ct = new Customer();
		Thread th = new Thread(ct);
		th.start(); //run을 직접 호출하는 것이 아니라 start 호출하면 시스템이 적당한 시기에 대신 호출함. - 콜백메소드
	}

	@Override
	public void run() {
		//빵 주세요
		System.out.println("run호출 성공");
	}

}
