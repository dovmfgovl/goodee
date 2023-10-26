package bclass.board;

import java.util.List;
import java.util.Map;

//화면과 로직(모델계층 - 데이터계층과 업무 프로세스 처리)을 분리하자
//화면과 로직을 연결해주는 클래스 설계함
//로직(입력, 수정, 삭제, 전체조회, 상세조회 업무내용 - 메소드 5개 설계함)
//		입력인 경우 - 성공이면 1을 반환하고 실패이면 0을 반환 - 누가 반환하지? - 오라클 서버 (=> 토드...dept에 추가 했음)
//5가지 메소드의 리턴타입과 파라미터 타입을 결정해야 함
//공통점 찾아내서 하나의 메소드로 합칠 수 있는 것인지 아니면 메소드를 다 분리해야 하는지 결정 = 클래스 설계
public class BoardController {
	//전역변수
	BoardDao bDao = new BoardDao(this); //this는 클래스와 클래스의 관계를 뜻함. 여기서 this가 어떤 클래스인가는 JVM이 모름. 그러므로 JVM은 생성자 생성 불가. 또한 파라미터를 갖는 생성자는 JVM이 자동 생성해주지 않음. 그러므로 BoardDao 클래스에 생성자 만들어야 함.
	public List<Map<String, Object>> getBoardList(){
		System.out.println("getBoardList호출 성공");
		return null;
	}
}
