package jdbc.oracle;
//반드시 테이블에 설계된 컬럼만 선언할 수 있는 건 아니다
//화면과는 상관 없지만 업무 프로세스를 처리하기 위해서 추가로 필요한 변수도 선언하세요 - 보이지 않는 부분 - 찾아서 변수를 선언할 수 있다.
public class BookVO {
	private int b_no      = 0;
	private String b_title   = "";
	private String b_author  = null;
	private int b_price   = 0;
//	int count = 5;//도서 주문량
	//페이징 처리 - 페이지 네비게이션
//	int start = 0;
//	int end = 0;
//	int pagePerList = 10;
//	int totalRecord = 45;
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) { //# save해서 전역변수에 write한다.
		this.b_no = b_no;
	}
	public String getB_title() { //# 리턴타입이 있다. 전역변수에 담긴 값을 read할 때 호출하는 get메소드 
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
}
