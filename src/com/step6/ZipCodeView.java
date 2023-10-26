package com.step6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.util.DBConnectionMgr;

public class ZipCodeView extends JFrame implements ActionListener, FocusListener, MouseListener { //interface는 여러 개 implements 할 수 있다.
	//선언부
	String zdo = null;
	//물리적으로 떨어져 있는 db서버와 연결통로 만들기
	Connection 			con 	= null;
	//위에서 연결되면 쿼리문을 전달할 전령의 역할을 하는 인터페이스 객체 생성하기
	PreparedStatement 	pstmt 	= null;
	//조회된 결과를 화면에 처리해야 하므로 오라클에 커서를 조작하기 위해 ResultSet추가
	ResultSet 			rs 		= null;
	//JFrame 은 기본적으로 BorderLayout이다(동,서,남,북,중앙 배치)
	//디폴트는 FlowLayout, ->  BorderLayout -> setLayout
	//jp_north.add("Center", jtf_dong)
	//jp_north.add("West",jbtn_search)
	JPanel jp_north = new JPanel();//Div태그 span생각
	//insert here
	String zdos[] = {"전체","서울","경기","강원"};
	String zdos2[] = {"전체","부산","전남","대구"};
	Vector<String> vzdos = new Vector<>();//vzdos.size()==>0
	JComboBox jcb_zdo = new JComboBox(zdos);//West
	JComboBox jcb_zdo2 = null;//West
	JTextField jtf_search = new JTextField("동이름을 입력하세요.");//Center
	JButton jbtn_search = new JButton("조회");//East
	String cols[] = {"우편번호","주소"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data,cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JTableHeader jth = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	String zdos3[] = null;
	 DBConnectionMgr dbMgr = null;//싱글톤 패턴으로 관리한다. 복제본을 만들지 않는다. 절대로....
	MemberShipView memberShipView = null; //null이 뭔가를 가리키는 시점은 ZipCodeView 생성자가 호출될 때
	//생성자
	public ZipCodeView() {
	}

	public ZipCodeView(MemberShipView memberShipView) {
		this.memberShipView = memberShipView; //재정의, 치환하기
	}

	//화면처리부
	public void initDisplay() {
		jtb_zipcode.requestFocus();
		jtf_search.addFocusListener(this);
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addActionListener(this);
		//북쪽 배치하는 속지를 FlowLayout-> 동서남북중앙 - UI솔루션
		jp_north.setLayout(new BorderLayout());
		/*	*/
		//vzdos.copyInto(zdos2);
		for(int x=0;x<zdos2.length;x++) {
			vzdos.add(zdos2[x]);
		}
		for(String s:vzdos) {
			System.out.println("s===>"+s);
		}
		//jcb_zdo2 = new JComboBox(zdos3);//West
		//jp_north.add("East",jcb_zdo2);
		jp_north.add("Center",jtf_search);
		jp_north.add("East",jbtn_search);
		this.add("North",jp_north);
		this.add("Center",jsp_zipcode);
		this.setTitle("우편번호 검색");
		this.setSize(430, 400);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		ZipCodeView zcs = new ZipCodeView();
		zcs.initDisplay();//화면이 먼저 열리도록 하고 오라클서버를 나중에 연결하자
		//zcs.refreshData("가산");
	}
	/******************************************************
	 * 사용자로부터 동이름을 입력 받아서 조건 검색을 구현하기
	 * @param dong - 동이름
	 * sql문
		SELECT zipcode, address - 두 개의 컬럼이 DTO or Map - > List담아라 - > row레벨을 담는다
		  FROM zipcode_t
		 WHERE dong LIKE ?||'%';	  
	 * 화면이 존재하는 경우 DB서버에서 가져온 정보를 가지고 후처리를 해야 함
	 * return타입을 void로 했으니까 이 메소드에서 화면처리까지 진행함
	 * UI - react - 화면과 로직(Model계층-UI+데이터셋만난다) 분리  - 
	 * 데이터셋에 데이터를 추가하는 것은 row단위(1차배열,  Vector)로 처리된다
	 * DefaultTableModel -> addRow(Object[]), addRow(Vector)
	 * ClassNotFoundException - > ojdbc6.jar ->  build path
	 * NullPointerException발동 -> con.prepareStatement("SELECT문"); - con이 널이다. ip주소, port:1521, 1522, 1523
	 * scott/tiger - 인증실패관련메시지
	 * sid가 이미 설치된 컴터 orcl
	 * SQLException은 sql문의 오류이다. 자바의 문제가 아님 - 토드에서 단위테스트 해볼것.
	 ******************************************************/
	public void refreshData(String dong) {
		List<Map<String,Object>> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT zipcode, address    ");
		sql.append("  FROM zipcode_t           ");
		sql.append(" WHERE dong LIKE ?||'%'");
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();//물리적으로 떨어져 있는 서버와 연결통로 확보
			pstmt = con.prepareStatement(sql.toString());//쿼리문을 먼저 스캔하여 있을 지 모르는 변수의 자리를 치환할것.
			pstmt.setString(1, dong);//dong, 당산, 가산, 공덕
			rs = pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("zipcode", rs.getInt("zipcode"));
				rmap.put("address", rs.getString("address"));
				list.add(rmap);
			}
			System.out.println(list);//주소번지가 33번 출력될것이다. - 단위테스트 하자
			//메소드 설계가 리턴타입이 빠져 있으므로 화면 처리까지 여기서 해야 함.
			for(int i=0;i<list.size();i++) {//33번 반복됨 - row수
				Map<String, Object> map = list.get(i);
				Vector<Object> v = new Vector<>();
				v.add(0,map.get("zipcode"));
				v.add(1,map.get("address"));
				dtm_zipcode.addRow(v);
			}
		} catch (SQLException se) {
			System.out.println(sql.toString());//출력된 쿼리문을 갈무리해서 토드에서 확인해 볼것.
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_search || obj == jtf_search) {
			System.out.println(jtf_search.getText());//당산
			String dong = jtf_search.getText();
			refreshData(dong);
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		Object obj = e.getSource();
		if(obj == jtf_search) {
			jtf_search.setText("");
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount()==2) { //더블클릭 한거야?
			//화면 테이블에서 더블클릭했을 때 선택된 로우의 index값을 반환해줌
			int index = jtb_zipcode.getSelectedRow(); 
			int zipcode = (int)dtm_zipcode.getValueAt(index, 0); //가상머신 1.8부터 오토박싱을 통해서 int와 Wrapper 클래스는 자동으로 형전환 //선택된 로우의 우편번호가 담김
			String address = (String)dtm_zipcode.getValueAt(index, 1);
			System.out.println(zipcode +", "+address);
			//insert here - 부모창인 회원가입 창에서 우편번호와 주소자리(MemberShipView)에 조회된 결과를 자동으로 출력해줌
			//부모(MemberShipView)의 주소번지가 필요하다.
			//valueOf 메소드의 파라미터 자리에 어떤 값이 오든 String 타입으로 형전환 해주는 메소드이다. 
			//관전 포인트 하나 더 - 싱글톤으로 제공되는 메소드입니다. 
			//MemberShipView를 인스턴스화 하면 그 때 즉시 전역변수의 ZipCodeView 객체가 생성되고 이 때 파라미터 자리에 있는 this는
			//앞에 인스턴스화를 통해 현재 로딩 중인 그 원본이므로 복사본이 아니다. 
			memberShipView.jtf_zipcode.setText(String.valueOf(zipcode));
			memberShipView.jtf_address.setText(String.valueOf(address));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}