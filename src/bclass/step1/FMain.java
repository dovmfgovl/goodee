package bclass.step1;
//메소드를 선언할 수 있다는 건 리턴타입과 파라미터를 결정할 수 있어야 한다.`
import java.util.ArrayList;
import java.util.List;

import bclass.board.BoardVO;

//입력 수정 삭제 조회 상세보기
//입력, 수정, 삭제 - return int로 한다. 파라미터는 BoardVO로 한다
//전체 조회 - List<BoardVO>, List<Map>
//반복되는 코드를 줄이기 위한 방법으로 공통분모를 생각해본다.
//		1. 반복되는 코드를 모두 모아서 한 눈에 보이게 펼치고 리턴타입과 파라미터에 대한 선택
//추출한 데이터를 가지고 연산처리를 할 경우 타입체크가 필수임으로 이런 경우는 VO를 제네릭으로 한다.
//Map<String, Object>를 하면 Object -> int or Object->double 형변환 하다보면 => ClassCastingException이 발생 - 그러므로 VO를 제네릭으로!
//설계단계 - 화면 정의서, 요구사항 정의서 , 클래스 다이어그램(클래스 설계: 클래스 관계), 유스케이스 다이어그램(업무담당자의 요구사항을 그림 - 절차)
//*BoardDao.java 설계하여 처리하시오.
//		왜 오라클서버 연동하는 클래스를 추가로 설계하였나?
//		JDBC API(반복되는 코드가 늘어남 - 업무에 대한 규칙이 바뀌면 코드를 수정해야 함)->
//			반복되는 코드를 줄여주는 그러나 쿼리문은 남아있는 myBatis(라이브러리 - main이 없는 클래스)를 사용하여 처리함
//			전체적인 클래스 설계가 변한다(야근) | 변하지 않는다(5일)
//			클래스를 독립적으로 나누어 관리한다.
//			클래스가 분리되면 인스턴스화를 잘 해야한다. - 생성자의 파라미터를 잘 선택한다.
public class FMain {
	//입력 처리
	/**************************************************************************************
	 *  INSERT INTO 테이블명(컬럼명1, 컬럼명2,..) VALUES(?,?,?,?,?,?,?,?)
	 *  쿼리문을 자바코드에 왜 적었나? - 파라미터 자리를 결정할 수 있다. 갯수, 타입, 컬럼명, 컬럼타입으로
	 * @param BoardVO //물음표가 8개니까...
	 **************************************************************************************/
	//public int boardInsert(int fb_no, String fb_title, String fb_writer, String fb_int.....//이렇게 일일히 다 적을순 없다!) 그래서 아래처럼 VO넣기
	//public int boardInsert(Map<String, Object> pmap) { //아래 하나를 먼저 익히고 Map은 직접 해보자~
	public int boardInsert(BoardVO bVO) {
		int result = -1;
		//오라클은 커밋해야 된다면서?(물리적인 테이블에 반영 위해서는) - 자바는 디폴트값이 autocommit으로 설정됨
		//1) con.setAutocommit(true);
		//2-1) con.setAutocommit(true);
		//2-2)con.commit();//자바에서 호출가능
		return result;
	}
	//수정 처리 - 있는 걸 바꾼다 - PK는 수정할 수 없다. - 따라서 7개만 수정이 가능하다.
	/**************************************************************************************
	 *  update dept set dname =:dname, loc =:loc where deptno =:deptno;
	 *  쿼리문을 자바코드에 왜 적었나? - 파라미터 자리를 결정할 수 있다. 갯수, 타입, 컬럼명, 컬럼타입으로
	 * @param BoardVO
	 **************************************************************************************/
	public int boardUpdate(BoardVO bVO) {
		int result = -1;
		return result;
	}
	//삭제 처리
	/**************************************************************************************
	 *  DELETE FROM freeboard where fb_no =?;
	 *  쿼리문을 자바코드에 왜 적었나? - 파라미터 자리를 결정할 수 있다. 갯수, 타입, 컬럼명, 컬럼타입으로
	 * @param BoardVO
	 **************************************************************************************/
	public int boardDelete(int fb_no) {
		int result = -1;
		return result;
	}
	//전체 조회 처리
	/**************************************************************************************
	 *  SELECT fb_no, fb_title, fb_writer, fb_hit, fb_group(댓글쓰기 위한 것), fb_step(댓글 순서), fb_date FROM freeboard
	 *  WHERE fb_title LIKE ?||'%'
	 *  	 AND (OR) fb_date LIKE ?
	 *  	 AND (OR) fb_writer LIKE ?
	 *  쿼리문을 자바코드에 왜 적었나? - 파라미터 자리를 결정할 수 있다. 갯수, 타입, 컬럼명, 컬럼타입으로
	 * @param BoardVO
	 **************************************************************************************/
	//public List<BoardVO> boardList(Map<String, Object> pmap) {
	public List<BoardVO> boardList(BoardVO pbVO) { //전체 조회니까 파라미터 필요없음 -> 조건검색을 추가하면 파라미터 추가(넓은 의미의 BoardVO로)
		List<BoardVO> bList = new ArrayList<>();
		return bList;
	}
	//상세보기 처리
	public BoardVO boardDetail() { 
		BoardVO rbVO = null;
		return rbVO;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 *클래스 
 * 1) 기능처리 위한 클래스
 * 2) 데이터셋을 위한 클래스 - 복습 - 단단히 할 것!
 * 3) 서블릿 -> JSP학습 - Web 기반 서비스 - URL 이용 - 네트워크 프로그래밍(소켓) - maint 메소드는 없다.
 * 3-1) 모바일(앱) -> 3 + 3-1 -> 하이브리드 앱개발 - 함수형 프로그래밍 언어(람다식, 화살표 함수)
 */