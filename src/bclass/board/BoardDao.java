package bclass.board;
//DAO(Data Access Object) - 영속성을 제공하는 오라클 서버와 연계하는 역할만 전담
//클래스 사이의 결합도를 낮춰야 한다. - 재사용성을 높여야 한다.
public class BoardDao {
	BoardController boardController = null; //null - 주소번지 안찍힘 - 타입이 결정되지 않음 - 모른다.
	public BoardDao(BoardController boardController) {
		this.boardController = boardController;
	}

}
