package com.week3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
//main스레드와 통신객체 사이에 경합이 벌어질 수 있어서 굳이 Thread 상속 받음 - 안정화(메신저)
public class TimeServer extends Thread {
	//아래 소켓은 서버소켓에 접속해온 클라이언트의 소켓정보를 쥐고 있다.
	//TimeClient에서 new Socket(ip, port); 호출될 때 결정되므로 일단 null이다.
	Socket client = null;
	public TimeServer(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			while(true) {
				//서버소켓에 접속한 클라이언트 소켓을 가지고 OutputStream을 생성하면 writeObject메소드를 통해서
				//오브젝트단위로 메시지를 쓴다
				System.out.println("server run호출");
				oos.writeObject(getTime());
				try {
					sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				} 
			}
		} catch (Exception e) {
			try {
				client.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	//서버측에서 CalendarAPI 를 이용해 현재 시간 정보를 반환하는 메소드 설계한다
	//반환타입과 리턴타입을 결정해 본다.- 파라미터는 필요없다. -리턴타입은 String한다.
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0" + hour : "" + hour) + ":" +
		(min < 10 ? "0" + min : "" + min)  +	":" +
		(sec < 10 ? "0" + sec : "" + sec) ;
	}
	public static void main(String[] args) {
		int port = 5000;
		//선언과 생성을 나누어 하는 건 network는 반드시 예외처리를 해야함
		//사용된 자원은 반납해야 하므로 catch블록이나 finally블록에서 닫아주어야 함
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("해당포트는 이미 사용중입니다.");
			try {
				server.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}///////////////////// end of try
		//여기 까지 진행되었다면 포트도 점유했고 서버소켓도 정상적으로 만들어짐
		System.out.println("TimeServer started successfully...");
		while(true) {
			try {
				//클라이언트 소켓이 접속해 올 때까지 기다리고 있다. - waiting 상태. 다음 코드가 진행되지 않음
				client = server.accept();
				if(client !=null) {
					//System.out.println(client);
				}
				System.out.println("New client connected...");
				//전역변수로 선언된 client가 69라인에 실체가 생김
				TimeServer ts = new TimeServer(client); //생성자 파라미터로 넘겨서 생성자 안에서 InputStream, OutputStream 생성함
				ts.start();
				System.out.println("New TimeServer Thread started...");
			} catch (Exception e) {
				System.out.println("Can't start server thread!!!");
				e.printStackTrace();
				try {
					client.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}////////////////////// end of main 
	}//////////////////////// end of main //////////////////////


}//end of TimeServer
/*
 *서버측
 *ServerSocket 생성함 - SeverSocket sever = new ServerSocket(5000);
 *기다림 지속 --
 *그 다음 코드는 진행되지 못한다. - 서버측에도 클라이언트와의 소통으로 인한 상태값을 로그로 남긴다. - JFrame
 *initDisplay()
 *서버가 준비되기 전에 화면은 먼저 연다(출력, 보여주자 - 로그를 출력하는 화면 - JTextArea - 멀티로우 입력 가능함)
 *Socket client = sever.accept(); //서버소켓에 접속한 소켓정보를 쥐게 된다.
 *
 * 클라이언트측
 * new Socket("서버의 IP주소", 5000); //인스턴스화 -> 서버측에 클라이언트측의 소켓객체를 전달함 - 통신채널 열린다.
 */




