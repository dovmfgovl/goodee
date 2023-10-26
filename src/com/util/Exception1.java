package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.step5.DeptManager3;

//테스트 시나리오를 작성할 수 있다.
//무엇을 테스트 할 것인가?
//예외처리를 하는 것은 서비스 안정화를 위한 필수이다.
public class Exception1 {
	DBConnectionMgr dbMgr = null; //인스턴스화를 직접 하지 않는다.
	//전역변수 자리에 추가한 인스턴스화는 언제 메모리에 상주하는가?
	// -> new Exception1() 했을 때 비로소 그 때야 메모리에 상주됨 - 시점
	DBConnectionMgr dbMgr2 = new DBConnectionMgr(); 
	Connection con = null;
	PreparedStatement pstmt = null; //쿼리문을 스캔. select: pstmt.executeQuery(): ResultSet, insert | update | delete -> executeUpdate(): int
	ResultSet rs = null;
	Exception1(){
		dbMgr = DBConnectionMgr.getInstance(); //여기서 인스턴스화를 함으로써 NullPiontException을 피할 수 있게 됨
		System.out.println("Exception1()"+dbMgr); ///////////////////같은 원본
		test(20);
	}
	public void test(int deptno) {
		System.out.println("test() : " +dbMgr); /////////////////같은 원본
		try {
			//인터페이스가 getConnection메소드 호출을 통해서 주소번지 갖게 되었다(메모리 상주하게 됨). -> NullPointerException
			con = dbMgr.getConnection();
			System.out.println(con);
			pstmt = con.prepareStatement("SELECT deptno, dname, loc FROM dept WHERE deptno=?");
			pstmt.setInt(1, deptno);
			rs= pstmt.executeQuery(); //오라클 서버에게 select 처리해줘
			System.out.println(rs.next()); //true
			System.out.println(rs.isFirst());
			System.out.println(rs.next()); //true
			//System.out.println(rs.isLast());
		} catch (Exception e) {
			e.printStackTrace(); /////////////////////////////디버그 할 때 꿀인 메소드!!!!!!!!!!!!!!!!!!////////////////////////////////
		}
	}
	public static void main(String[] args) {
		//new Exception1();
		DeptManager3 dm = new DeptManager3();
		dm.getMapList();
	}

}
