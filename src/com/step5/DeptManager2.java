package com.step5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//ActionListener al = new DeptManager();
//자바는 단일 상속만 가능하다. - 다중상속은 불가함 - 다중상속의 단점을 보완하기 위해 인터페이스가 제공됨
//단 인터페이스는 여러 개를 implements 할 수 있다.(추상클래스, 인터페이스는 설계관점에서 중요함 - 지금은 특징, 컨벤션 암기 정도만!)
public class DeptManager2 extends JFrame implements ActionListener{
	//선언부
	List<Map<String, Object>> deptList = new ArrayList<>(); //왜 전역변수로 하는가? 입력|수정|삭제|조회
	String header[] = {"부서번호", "부서명", "지역"};
	String datas[][] = new String[0][0]; //2차 배열 - 대괄호 2쌍이 필요함
	//생성자의 파라미터를 통해서 서로 다른 클래스가 의존관계를 맺고 하나의 기능을 서비스 할 수 있다.
	//생성자도 파라미터를 여러 개 가질 수 있다. - 메소드 오버로딩
	DefaultTableModel dtm_dept = new DefaultTableModel(datas, header); //html에서는 <table>태그 - 양식이 있음 - 양식이니까 자바가 있어야 DataSet 구성함
	JTable jt_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jt_dept);
	JPanel jp_north = new JPanel();
	JButton jbtnSelect = new JButton("조회");
	JButton jbtnDelete = new JButton("삭제");
	JButton jbtnAdd = new JButton("행추가");
	JButton jbtnDel = new JButton("행삭제");
	JButton jbtnExit = new JButton("종료");
	//생성자
	DeptManager2(){
		getDeptList();
		initDisplay(); // 메소드 호출은 생성자에서 하는 연습하기..!
	}////////////// end of DeptManager/////////////
	public List<Map<String, Object>> getDeptList(){
		Map<String, Object> map = new HashMap<>(); //복사본
		map.put("DEPTNO", 10); //cul 3가지 담아주는건 Map, row 담아주는 건 List
		map.put("DNAME", "영업부");
		map.put("LOC", "부산");
		deptList.add(map);
		map = new HashMap<>();
		map.put("DEPTNO", 20); 
		map.put("DNAME", "개발부");
		map.put("LOC", "대구");
		deptList.add(map);
		map = new HashMap<>();
		map.put("DEPTNO", 30); 
		map.put("DNAME", "인사부");
		map.put("LOC", "서울");
		deptList.add(map);
		return deptList;
	}
	//화면처리부
	public void initDisplay() {
		jbtnSelect.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnAdd.addActionListener(this); //행 추가
		jbtnDel.addActionListener(this); //행 삭제
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtnSelect);
		jp_north.add(jbtnDelete);
		jp_north.add(jbtnAdd); //행 추가 JPanel 붙이기
		jp_north.add(jbtnDel);
		jp_north.add(jbtnExit);
		this.add("North", jp_north);
		this.add("Center", jsp_dept);
		this.setSize(500, 400); //this: DeptManager
		this.setVisible(true);
	}/////////////// end of initDisplay////////////
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		DeptManager2 dm = new DeptManager2(); // new JFrame() 호출되는 것이다. 상속 받았으니까
	}//////////////// end of main ////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed호출은 반드시 addActionListenr가 있어야 됨");
		Object obj = e.getSource();
		//행 삭제 해보기
		if(obj == jbtnDel) {
			//dtm_dept.removeRow(0);
			int index = jt_dept.getSelectedRow(); // 사용자가 선택한 로우의 index값을 반환함
			if(index<0) { //-1 반환(EOF)
				JOptionPane.showMessageDialog(this,"삭제할 행을 선택하시오.", "INFO", JOptionPane.INFORMATION_MESSAGE);//this는 JFrame을 가리킴. 얘가 열려야 show~도 열리기 때문에
				return; //메소드 탈출
			} else {
				dtm_dept.removeRow(index);
			}
		}
		//행 추가 해보기
		else if(obj == jbtnAdd) {
			//Vector addRow = new Vector();
			Object addRow2[] = new Object[3];
			dtm_dept.addRow(addRow2);
		}
		//너 삭제 할거니?
		else if(obj == jbtnDelete) {
			int index = jt_dept.getSelectedRow(); // 사용자가 선택한 로우의 index값을 반환함
			if(index<0) { //-1 반환(EOF)
				JOptionPane.showMessageDialog(this,"삭제할 데이터를 선택하시오.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return; //메소드 탈출
			}
			//여기로 못 오게 함
			else {
				System.out.println(index); //index값을 add(int, E) 1 -> remove(1),
				//insert here
				Map<String, Object> map = deptList.remove(index);
				System.out.println(map+ ", map.get(DEPTNO) : "+ map.get("DEPTNO"));
				//insert here - '삭제 성공하였습니다' 를 입력하기
				if(map != null) { //삭제가 안 된 경우를 의미함
					refreshData();
					JOptionPane.showMessageDialog(this,"삭제 성공하였습니다.", "info", JOptionPane.INFORMATION_MESSAGE);					
				}else {
					JOptionPane.showMessageDialog(this,"삭제 실패하였습니다.", "info", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
		//너 조회버튼 누른거야?
		else if(obj == jbtnSelect) {
			System.out.println("조회버튼 클릭"); //log
			//웹 개발이더라도 html이 데이터를 쥘 수는 없다.
			//html과 자바 코드를 섞어쓰기가 가능한가? - 불가 - jsp 공부함 - 자바 자료구조를 JSON형식으로 넘기기
			//dtm_dept는 실제 데이터를 포용함
			//JTable은 클릭이벤트 같은 것은 가능함 - 실제 데이터를 쥐고 있지 못함
			//getRowCount는 데이터의 로우 수 반환 - 3건
			while(dtm_dept.getRowCount()>0) { //dtm은 데이터셋(자바 측에서) 받는 클래스이다.
				dtm_dept.removeRow(0); //0번째 로우를 지우는 이유는 로우가 삭제 될 때 마다 dtm의 로우 수가 줄어든다. - 왜? --> Array3.java 확인
			}
			for(int i=0; i<deptList.size(); i++) {
				Map<String, Object> map = deptList.get(i);
				Vector<Object> v = new Vector<>(); //3번 생성됨
				v.add(0, map.get("DEPTNO"));
				v.add(1, map.get("DNAME"));
				v.add(1, map.get("LOC"));
				dtm_dept.addRow(v);
			}
		}/////////// end of if ////////////////////////
	}////////////// end of actionPerformed ///////////
	//새로고침(F5) 구현하기
	public void refreshData() {
		while(dtm_dept.getRowCount()>0) { //dtm은 데이터셋(자바 측에서) 받는 클래스이다.
			dtm_dept.removeRow(0); //0번째 로우를 지우는 이유는 로우가 삭제 될 때 마다 dtm의 로우 수가 줄어든다. - 왜? --> Array3.java 확인
		}
		for(int i=0; i<deptList.size(); i++) {
			Map<String, Object> map = deptList.get(i);
			Vector<Object> v = new Vector<>(); //3번 생성됨
			v.add(0, map.get("DEPTNO"));
			v.add(1, map.get("DNAME"));
			v.add(1, map.get("LOC"));
			dtm_dept.addRow(v);
		}
	}//////////////////end of refreshData//////////////////
}
