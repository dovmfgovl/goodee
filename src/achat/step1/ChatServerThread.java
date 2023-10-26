package achat.step1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

public class ChatServerThread extends Thread {
	ChatServer cs = null;
	Socket client = null;
	ObjectOutputStream oos = null; //말할 때 사용
	ObjectInputStream ois = null; //들을 때 사용
	//
	String chatName = null; //현재 서버에 입장한 클라이언트 스레드의 닉네임 저장
	//생성자의 파라미터
	//public ChatServerThread(List<ChatServerThread> globalList, JTextArea jta_log) { //여러개 넘기는 것보다 아래처럼 ChatServer cs 로 덩어리째로 넘기는게 편하다
	public ChatServerThread(ChatServer cs) {
		cs.jta_log.append("ChatServerThread호출" + "\n");
		//생성자 안에서 globalList에 현재 입장한 키위를 추가한다.
		this.cs = cs;
		this.client = cs.socket;
		cs.jta_log.append("client"+ client + "\n");
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			//100|kiwi - 입장하기 처리를 생성자에서 벌써 했다.
			//생성자 안이면 입장했다는 걸 어떻게 증명한다는 건가?
			String msg = (String)ois.readObject(); //누가 보낸 걸 듣나요? ChatClient
			cs.jta_log.append(msg+"\n"); //로그를 남긴다(출력) - 추적하다
			StringTokenizer st = new StringTokenizer(msg, "|");
			st.nextToken(); //100
			chatName = st.nextToken(); //kiwi
			cs.jta_log.append(chatName+"님이 입장하였습니다.\n");
			
			//////////이미 kiwi, tomato는 입장해 있다고 전제할 때)
			//내가(apple) 입장하기 전에 이미 입장해 있는 친구들에게도 메시지를 전달해야 한다.
			//kiwi가 입장했을 땐 cs.globalList.size()가 0이라서 for문을 경유하지 않는다.
			for(ChatServerThread cst: cs.globalList) { //cs.globalList.size() = 2 - apple이 아직 안들어옴 //처음엔 = 0
				System.out.println(cst.chatName); //kiwi, tomato
				System.out.println(this.chatName); //this는 이제 막 들어온 apple이다. 이전에 kiwi, tomato가 들어왔을 때도 얘네가 this를 의미했다.
				this.send(100+"|"+cst.chatName); //나 입장했어요
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			cs.globalList.add(this); //3명이 채워짐 - this는 ChatServerThread다 -> 얘를 globalList(ChatServer)로 넘긴다 -> ChatServerThread this(kiwi or tomato or apple) //apple까지 더해져야 아래 broad를 통해서 채팅을 받을 수 있다. 아래 broad가 얘 위에 있으면 apple을 빼고 챗을 받게 되는 상황인 것 - 위치 설정이 중요하다!
			this.broadCasting(msg);
			//apple이 입장했을 때 이미 kiwi, tomato 입장해 있다
			//cs.globalList.add(this); // this는 kiwi, tomato, apple?, 아님 이걸 어떻게 서버가 구분할 수 있나요?
			//cs.globalList.add(this); //this는 ChatServerThread이다. - List<ChatServerThread> globalList
			//cs.globalList.size(); //3명
			//cs.jta_log.append("");
			//System.out.println(this.cs.globalList.size()); //0
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}	
	//run메소듣도 콜백메소드 입니다. - 개발자가 직접 호출하지 않아요
	//시스템에서 대신 호출해 줌
	@Override //@: annotation
	public void run() {
		System.out.println("ChatServerThread의 run호출");
		//insert here - 듣고 말하기(방송)
		//말하기 처리는 메소드로 분리(for문 - 3사람에게 들은 걸 말해야 하니까)시킨다
		boolean isStop = false;
		String msg = null;
		try {
			start:
				while(!isStop) {
					msg = (String)ois.readObject();
					cs.jta_log.append(msg+"\n");
					//로그가 append될때마다 스크롤바가 현재 문자열의 위치를 자동으로 인식해서 이동처리
					cs.jta_log.setCaretPosition(cs.jta_log.getDocument().getLength());
					//언제 선언부와 생성부를 나누어서 작성하나요?
					//msg가 null일 수도 있다는 것을 의심해야함 - 이럴 때 선언부와 생성부를 나누어 작성
					StringTokenizer st = null;
					int protocol = 0;
					if(msg != null) { //msg 너 null 아니야? 하고 한 번 더 확인
						st = new StringTokenizer(msg, "|");
						protocol = Integer.parseInt(st.nextToken());
					}
					switch(protocol) {
//					case 100: {//입장하기 - 생성자에서 했잖아
//						
//					}break;
					case 200: {
						cs.jta_log.append("ChatServerThread : 200번 청취완료");
						String nickName = st.nextToken();//kiwi
						String message = st.nextToken(); //오늘 스터디할까?
						broadCasting(200+"|"+nickName+"|"+message); //oos.writeObject가 없나요? send에 있음
					}break;
					case 500: {
						
					}break start;
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//서버가 클라이언트에게 들은 것을 방송(여러 사람 - 스레드를 붙임)하는 것이다. 
	//왜 파라미터 자리인가? - 매번 입력되는 메시지가 달라진다 - 지역변수
	//oos.writeObject(message ==> "200|kiwi|apple|오늘스터디할까?"); //200번에서 kiwi가 apple에게 오늘스터디할까?
	 public void broadCasting(String message) {
		 //for(int i = 0; i<cs.globalList.size(); i++) { //cs.globalList.size() = 3
		 for(ChatServerThread cst: cs.globalList) {
			 cst.send(message);
			 //클라이언트들에게 서버가 들은 메시지를 보낸다. - OutputStream
			 //ObjectOutputStream oos  = new ObjectOutputStream(socket.getOutPutStream());
			 //oos.writeObject(message); //200: 다자 간 대화 -> case 문에서 사용 //oos하려면 소켓 필요
		 }
	 }
	 //DM을 처리하는데 필요한 메소드를 고려하여 메소드를 하나 더 추가해본다.
	 public void send(String message) {
		 try {
			 oos.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace(); //stack에 쌓여 있는 로그 히스토리ㅣ를 출력함
		}
	 }
}
