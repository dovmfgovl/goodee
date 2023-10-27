package bclass.step2;

import java.util.StringTokenizer;

class Life1{
	String s= null; // 게으른 인스턴스화를 할 때는 일단 null로 선언해둔다. - 필요할 때 내가(개발자인가? 스프링인가?에 따라 주체 바뀜) 주입해줄게
	//초기화
	public void init() {
		//Spring을 사용하지 않은 경우이다 - 왜냐하면 내가 직접 new 했으니까
		s = new String("300|kiwi"); //객체에 대한 라이프 사이클을 개발자가 관리해야 한다.
	}
	//자원활용
	public void service() {
		StringTokenizer st = new StringTokenizer(s, "|");
		st.nextToken(); //300
		String who = st.nextToken(); //kiwi
		System.out.println(who); //kiwi
	}
	//지원반납 - 소멸
	//사용한 자원(JDBC, network)을 반납하지 않으면 gc가 스레드 스케줄에 따라서 수거를 한다. 묵시적으로 처리된다.
	//명시적으로 해라 - 자바튜닝팀
	public void destroy() {
		if(s != null) {
			s = null;
			//명시적으로 호출할 수 있다. - 메모리 점유와 관련있음 - 서버의 안정화 관련 - static 남용은 안된다. - 2년차 개발자들은 static 제약한다.
			System.gc(); //즉시 비워지는 건 아니다. - gc도 스레드가 관여되어 있음 - 스케줄에 따라서 점차적(자체 우선순위)으로 처리한다.
		}
	}
}
//메소드의 요청 순서에 따라 NullPointerException 발생할 수 있다
//트러블 슈팅 - 고려대상
public class LifeMain1 {

	public static void main(String[] args) {
		Life1 life = new Life1();
		life.init(); //얘 안 넣으면 s가 null이기 때문에 NullPointerException 발생
		//life.destroy(); //candidate 상태 - Gavage Collector - 찜 //위를 입력하고 아래에 이 destroy 입력하면 candidate 상태가 되어 또 NullPointerException 발생
		life.service();
	}

}
