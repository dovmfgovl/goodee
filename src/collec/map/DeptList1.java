package collec.map;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;
//myBatis DB 연동하기 - 30% 이상 반복코드를 줄여줌
//html에서 폼 전송을 통해 회원가입 및 주문 등록 할 때 반복되는 코드를 줄이기 위해
//사용될 수 있다. - Map
public class DeptList1 extends JFrame implements ActionListener {
	JPanel jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	String header[] = {"부서번호","부서명","지역"};
	String data[][] = new String[0][3];
	DefaultTableModel dtm = new DefaultTableModel(data, header);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	DeptVO init1(int deptno, String dname, String loc) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(deptno);
		dvo.setDname(dname);
		dvo.setLoc(loc);
		return dvo;
	}
	void arrayPrint() {
		DeptVO[] dvos = getDeptList1();
		for(int i=0; i<dvos.length; i++) {
			Vector<Object> v = new Vector<>();
			v.add(dvos[i].getDeptno());
			v.add(dvos[i].getDname());
			v.add(dvos[i].getLoc());
			dtm.addRow(v);
		}
	}
		void listVOPrint() {
			List<DeptVO> list = getDeptList2();
			System.out.println(list.size());
			for(int i=0; i<list.size(); i++) {
				DeptVO dvo = list.get(i);
				Vector<Object> v = new Vector<>();
				v.add(dvo.getDeptno());
				v.add(dvo.getDname());
				v.add(dvo.getLoc());
				dtm.addRow(v);
			}
	}
		void listMapPrint() {
			List<Map<String, Object>> list = getDeptList3();
			Iterator<Map<String, Object>> iter = list.iterator(); //p. 574 Iterator 사용하기
			while(iter.hasNext()) {
				Vector<Object> v = new Vector<>();
				Map rmap = (Map)iter.next();
				v.add(rmap.get("deptno"));
				v.add(rmap.get("dname"));
				v.add(rmap.get("loc"));
				dtm.addRow(v);
			}
		}
	DeptVO[] getDeptList1() {
		DeptVO[] dvos = new DeptVO[3];
		for(int i=0; i<dvos.length; i++) {
			dvos[i] = init1((i+1)*10, "개발" + (i+1) + "팀", "서울" + (i+1));
		}
		return dvos;
	}
	
	List<DeptVO> getDeptList2(){
		List<DeptVO> list = new ArrayList<>();
		DeptVO dVO = null;
		for(int i=0; i<3; i++) {
			dVO = new DeptVO((i+1)*20, "개발" + (i+1) + "팀", "서울" + (i+1));
			list.add(dVO);
		}
		return list;
	}
	
	List<Map<String, Object>> getDeptList3(){
		List<Map<String, Object>> list = new ArrayList<>();
		//VO나 Map은 한 번에 한 개 로우만 담을 수 있다.
		//여러 번 담으면 맨 마지막 것만 기억하니까...
		Map<String, Object> map = null;
		for(int i=0; i<3; i++) {
			map = new HashMap<>();
			map.put("deptno", (i+1)*30);
			map.put("dname", "운영" + (i+1)+"팀");
			map.put("loc", "서울" + (i+1));
			list.add(map);
	}
		return list;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_sel) { //너 조회 버튼 누른거야?
			//arrayPrint();
			//listVOPrint();
			listMapPrint();
		}
	}
	void initDisplay() {
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jbtn_sel.addActionListener(this);
		jp_north.add(jbtn_sel);
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.setTitle("부서목록");
		this.setSize(600, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		DeptList1 dt = new DeptList1();
		dt.initDisplay();
	}

}
