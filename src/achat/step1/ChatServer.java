package achat.step1;

import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//왜 스레드를 굳이 상속받는 건가요? - 화면처리하는 메인메소드와 통신채널 설정하는 코드 분리
//혜택 - 화면처리와 네트워크 처리 분리한다 - 안전한 서비스 제공하기 위해서
public class ChatServer extends Thread {
	//List의 구현체 클래스는 ArrayList(스레드 불안전 - 조치가 없다, 배려 없다, 추가 로직 포함 안 됨), Vector(동시접속자를 배려하여 0.1초라도 먼저 들어오면 관리 해줌. 읽기 쓰기 속도 느림)
	//챗서버에 접속해 온 사용자에 대한 정보를 담는 Vector 선언임
	//다수의 클라이언트 요청을 처리하는 서버를 개발할 때 사용함
	List<ChatServerThread> globalList = null; //멀티스레드에서 안전한건 Vector(느림). 안전하지 않은 건 ArrayList(빠름)
	ServerSocket server = null; //3002번 대문 열어두기 //run메소드에 인스턴스화 함 - 가게 문을 열었다
	//서버는 들은 내용을 말하는 것이다. 
	//실제로 듣고 말하기는 ChatServerThread에서 처리한다.(쌤이 그렇게 설계했다)
	//run메소드에서 서버소켓에 접속해온 클라이언트 측의 소켓정보를 받게 되니까 - 메소드 내부에서 사용하려면 전역변수로 하자
	Socket socket = null;
	JFrame jf = new JFrame();
	JTextArea jta_log = new JTextArea(10, 60);
	JScrollPane jsp_log = new JScrollPane(jta_log
			, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED	//밑으로 스크롤바는 필요해지면 생성
			, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	// 좌우 스크롤바는 생성 안함
	public ChatServer() {}
	
	@Override
	public void run() { //통신에 대한 처리 - 지연, 끊김, 노이즈, 대기 
		//서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
	 	globalList = new Vector<>(); //ChatServerThread 담기 - 동시에 3명이 들어온다면 ArrayLIst 가 아닌 Vector
	 	boolean isStop = false;
	 	try {
	 		//만일 3002번 포트를 오라클 서버에서 점유하고 있다면 예외가 발생할 것이다.
	 		server = new ServerSocket(3002);
	 		jta_log.append("Server Ready.........\n"); //대기 중 - 손이 오기를 기다린다. - 다음 코드가 실행기회를 못 갖는다 - 흐름을 방해함 - 장애처리
	 		while(!isStop) {
	 			//서버소켓에 접속해 온 사용자의 소켓정보를 담는다.  - 멍 때림
	 			//Socket s  = new Socket("172.16.2.3", 3002); - ChatClient - 입장하기
	 			//socket은 ChatServer에서 선언한 전역변수인데 어떻게 클라이언트 소켓 주소번지를 쥐고 있는걸까?
	 			socket = server.accept(); //지연 발생하도록 함. 기다리는 중... ChatClient에서 소켓 만들어줘야함
	 			jta_log.append("client info:"+socket+"\n");	//여기 소켓은 클라이언트 소켓을 쥐고 있다.	
	 			//아래에서 this는 ChatServer를 가리킨다.
	 			System.out.println(this); //왜 파라미터로 넘기지? Socket 필요하니까 -> oos, ois
	 			//다형성
	 			Thread tst = new ChatServerThread(this); //this는 자기자신이니까 ChatServer를 말하는 것 - 왜 넘기나?: 협업(ChatServer와 ChatSeverThread) - 서버에 접속한 소켓정보를 ChatServerThread에서 사용해야 하니까 this로 넘긴다. //전역변수를 쥐어 ChatServerThread로 넘길 수 있다.//새로운 사람 들어올때마다 얘를 거쳐 인스턴스화 되므로 각자 다른 주소번지를 갖게 됨. 그에 따라 누가 채팅을 치는 건지 구분할 수 있게 되는 것
	 			//생성자 호출이 끝나고 나면 즉시 start() 호출된다 -> run() 호출한다.
	 			//100|kiwi
	 			tst.start(); //ChatServerThread의 run 호출된다.
	 			//break; //여기에 break를 살려두니 첫번째 client인 kiwi가 입장할 때는 입장했다는 창과 로그가 남았지만, 두번째로 tomato를 넣으니 창을 띄워지지만 tomato가 입장했다는 창과 로그가 뜨지 않았다....! 그 이유를 찾아보자....!!
	 		}
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	}
	public void initDisplay() {
		jta_log.setLineWrap(true); //줄바꿈 되도록 설정
		jf.setBackground(Color.orange);
		jf.add("Center", jsp_log);
		jf.setTitle("서버측 로그 출력화면 제공");
		jf.setSize(800, 600);
		jf.setVisible(true);
	}
	//메인메소드도 스레드라 했잖아요?
	//entry point - 시작점 - exe 파일 생성가능함 - 경합 벌어진다. - 끼어든다 
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
		System.out.println(cs);
		//두 메소드가 호출되었을 때 지연이 발생되는 메소드는 start()이다.
		//같은 메소드라도 처리되는 시간이 다르다 - 스케쥴링이 필요함 - 이럴 때 스레드 상속
		//this.sleep(10000),  this.wait(); this.notify();
		//대기상태에 있는 손님이 있다.
		cs.initDisplay();
		cs.start(); //순서가 중요하다. 얘가 위에 있다면 여기서 대기탄다 - this.wait(); -> this.notify(); 잠자는 스레드를 깨운다
	}

}
