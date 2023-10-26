package jdbc.oracle;

import java.util.List;
import java.util.Map;

public class List2 {
	void methodA(List<BookVO> bookList) {
		// 사용권 - 나신입 - 로그인 - 권한
		BookVO bVO = new BookVO(); //b_no, b_title, b_author, b_price -> private - thread가 관리함. List<ChatServerThread>
		//bVO.B_title = "수학의정석"; //private이라서 직접 변경 불가능
		bVO.setB_title("수학의정석"); //public으로 정의했으므로 변경 가능
		bVO.setB_author(null);
		System.out.println(bVO.getB_title().length()); //수학의정석 - 5
		System.out.println(bVO.getB_author()); //null
		System.out.println(bVO.getB_author().length()); //NullPointException
		//System.out.println(null.length()); //null과 ""빈 문자열을 구분할 것. ""는 null이 아니다  // NullPointException
		//System.out.println("".length()); 
		// 사용권 - 나초보
		bVO = new BookVO(); //LifrCycle - 생성 - 호출 - 죽임(메모리 회수 - 캔디데이트 상태 - 가비지컬렉터)
		System.out.println(bVO.getB_title().length());
	}
	void methodB(List<Map<String, Object>> bookList) {
		
	}
	public static void main(String[] args) {
		List2 li2 = new List2();
		li2.methodA(null);
	}

}
