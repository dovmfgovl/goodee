package com.week3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {
	JLabel jlbTime = null;
	TimeView tView = null;
	public TimeClient() {}
	public TimeClient(JLabel jlbTime) { //12, 13이 학습목표임!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		this.jlbTime = jlbTime;
	}
	public TimeClient(TimeView tView) {
		this.tView = tView;
	}
	//콜백메소드 - actionPerformed - 개발자가 직접 호출하지 못한다.
	@Override
	public void run() {
		System.out.println("run호출");
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		String timeStr = null;
		try {
			socket = new Socket("172.16.2.117", 5000); // 내 컴퓨터 안에서 할 때는 ip주소 대신 "localhost"도 가능 //ServerSocket 클라이언트의 소켓정보 쥔다.
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while(true) {
				//TimeServer에서 1초마다 getTime()호출로 알아낸 시간 정보를 oos.writeObject(getTime())하면
				//아래에서 들을 수 있다.
				timeStr = ois.readObject().toString();
				System.out.println(timeStr);
				//아래 코드는 TimeView에서 생성한 JLabel 컴퍼넌트에 직접 출력하는 문장
				//NullPointerException이 발생하지 않도록 맞는 생성자 호출하기
				System.out.println("TimeClient : "+jlbTime);
				jlbTime.setText(timeStr); // 이 부분이 학습목표임!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
			}////////////end of while///////////
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				//네트워크 관련 서비스 구현할 때, 생성된 객체 역순으로 닫음.
				ois.close();
				oos.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}////////////////end of run/////////////
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}


}
