package com.step5;

public class DeptDTO {//아래 3개를 한 묶음으로 관리하고 싶어서 //Dept집합 클래스는 3가지 정보 관리 위해 설계되었고 변수 3개 선언됨. 변수가 위변조 되는 것을 막기 위해 private
	private int deptno;
	private String dname;
	private String loc;
	public DeptDTO() {}
	//생성자의 파라미터 자리를 통해서 전역변수의 초기화(재정의) 함(set, get 대신! set, get을 하면 set3, get3개 씩이나 만들어야함)
	public DeptDTO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	private EmpDTO empDTO;
	public EmpDTO getEmpDTO() {
		return empDTO;
	}
	public void setEmpDTO(EmpDTO empDTO) {
		this.empDTO = empDTO;
	}
	public int getDeptno() { 
		return deptno;
	}
	public void setDeptno(int deptno) { //새로운 정보 재정의  - 전역변수에 담음 //직접 접근이 불가하니 public으로 setter, getter
		this.deptno = deptno;
	}
	public String getDname() { //변수 담긴 정보 읽어보기
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
