package collec.map;
//이 클래스는 Spring으로 가면 Lombok 라이브러리로 대체됨 -> Spring JPA로 DB연동을 하면 쿼리문 대신에 클래스 설계가 필요함
//접근제한자를 private으로 하는 이유가 웹서비스 시 싱글톤 처리
//인스턴스 변수에 직접 접근하는 방식이 아니라 사용자마다 인스턴스화를 통해서 지역적으로
//사용하고 소멸시킨다. - 로그아웃할 때 소멸시킨다. - 지역변수 성격으로 처리함(웹서비스라서 동시 접속자 수가 많으니까)
//지역변수의 성격을 갖는 파라미터 자리를 활용할 수 있어서 전역변수가 아니더라도 활용에 문제 없음
//파라미터 자리에 값을 넘겨서 처리하면 그 메소드 영역에서만 유지됨 - 람다식, 화살표 함수 - 코드의 양을 줄여줌
public class DeptVO { //자바와 오라클, 자바와 mysql,  자바와 몽고dB
	private int deptno; // oracle: number(5)
	private String dname; // oracle: varchar2(4000) - 가변형 타입 <-> char - 고정형
	private String loc;
	public DeptVO() {}
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	} 
}
