package collec.list;

public class RoomMain {
	Room r1 = null;
	Room r2 = null;
	public void room1() {
		r1 = new Room();
		r1.inwon = 7;
		r1.title = "스프링 스터디 3기 모집";
		r1.names.add("나초보");
		r1.names.add("유재석");
		r1.names.add("강호동");
	}
	public void room2() {
		r2 = new Room();
		r2.inwon = 7;
		r2.title = "보드 같이 타실 분";
		r2.names.add("나신입");
		r2.names.add("나일등");
		r2.names.add("이성계");
	}
	public static void main(String[] args) {
		//Spring에서는 개발자가 직접 인스턴스화 하지 않는다.
		//필요할 때 Spring이 대신(주도권이 넘어갔다) 객체를(자동) 주입해준다.
		//객체가 생성되는 시점에 따라 문제가 발생할 수 있다(객체 라이프 사이클) -> 탄생-활동-죽음(소멸-candidate상태{가비지컬렉터 - 자원회수})
		//이른(미리, 먼저해둔다. 전역변수 성격) 인스턴스화, 게으른(지역적으로 처리) 인스턴스화 나눈다.
		//그런데 NullPointerException이 발생하지 않는다.
		//왜냐하면 스프링 컨테이너가 대신 해주니까
		//또 라이프 사이클도 직접 관리해준다.
		RoomMain rm = new RoomMain();
		rm.room1();
		for(int i=0; i<rm.r1.names.size(); i++) {
			System.out.println("=====================");
			System.out.println("최대 인원수 : " + rm.r1.inwon);
			System.out.println("방제목 : " + rm.r1.title);
			System.out.println(rm.r1.names.get(i));
			System.out.println("=====================");
		}
	}

}
