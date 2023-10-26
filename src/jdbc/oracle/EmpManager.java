package jdbc.oracle;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//데이터셋을 담당하는 DefaultTableModel API 활용하기
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//ActionListener al = new EmpManager();
//List list = new Vector();
//List list = new ArrayLIst();
public class EmpManager extends JFrame implements ActionListener{
	JPanel jp_north = new JPanel();
	JButton jbtn_select = new JButton("조회");
	JButton jbtn_insert = new JButton("입력");
	JButton jbtn_update = new JButton("수정");
	JButton jbtn_delete = new JButton("삭제");
	String data[][] = new String[0][3];
	String header[] = {"사원번호", "사원명", "급여"};
	//데이터 셋이다. 화면이 아니다.
	DefaultTableModel dtm = new DefaultTableModel(data, header); //web 개발 -> JSON 역할이 됨 - 실제 데이터를 쥐고 있다
	JTable jt = new JTable(dtm); //양식(폼, 그림, 표)
	JScrollPane jsp = new JScrollPane(jt); //속지 만들어 줌
	public EmpManager() {
		init();
		}//////end of EmpManager
	public void init() {
		data = new String[][]{
				{"7566", "나신입", "3000"}
				,{"8455", "나초보", "4000"}
				,{"4851", "나일등", "4500"}
		};
	}
	public void initDisplay() {
		jbtn_update.addActionListener(this); //this는 EmpManager
		jp_north.setLayout(new GridLayout(1,4)); //default FlowLayout이다 - 왼쪽에서부터 오른쪽으로 배치된다. 그리고 공간이 남음
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);	
		System.out.println(data[0][1]); //나신입
		System.out.println(data[1][1]); 
		System.out.println(data[1][2]);
		System.out.println(data[2][0]);
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data);//2차 배열의 주소번지
		Container con = this.getContentPane();
		dtm = null;
		dtm = new DefaultTableModel(data, header);
		jt = null;
		jt = new JTable(dtm);
		jsp = null;
		jsp = new JScrollPane(jt);
		System.out.println("initDisplay호출");
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.setSize(500, 300);
		this.setVisible(true);
	}////////end of initDisplay

	public static void main(String[] args) {
		EmpManager em = new EmpManager();
		em.initDisplay();
	}////////end of main
	@Override
	public void actionPerformed(ActionEvent e) { //콜백메소드의 파라미터 자리는 JVM이 대신 주입(인스턴스화)해줌 - > arrow function이 생김
		Object obj = e.getSource();
		if(jbtn_update == obj) { //너 수정버튼 누른거야?
			//insert here 4000 -> 5000 변경
			System.out.println("수정버튼 누른거야?");
			System.out.println(dtm.getRowCount()); //3
			for(int i=0; i<dtm.getRowCount();i++) { //데이터셋은 테이블(로우+컬럼) 구조이다.
				//자바 api에서 메소드 이름 앞에 isXXXX가 있으면 리턴타입은 boolean이다 -> if문이나 for문에 사용가능한 메소드이다.
				if(jt.isRowSelected(i)) { //네가 선택한 로우값? - true, 만일 선택된 로우가 아니라면? - false
					//나초보랑 같은 로우값이라면
					//나초보를 가져오는 낱말카드 - String name = dtm.getValueAt(1,1) //나초보가 담김
					String cname = (String) dtm.getValueAt(i, 1);
					System.out.println("사용장가 선택한 로우의 이름은 ===>" +cname);
					if("나초보".equals(cname)) { //여기가 나초보에 해당되는 로우값이라면
						dtm.setValueAt(5000, i, 2);
				} else if("나신입".equals(cname)) {
					dtm.setValueAt(3500, i, 2);
				}else if("나일등".equals(cname)) {
					dtm.setValueAt(5500, i, 2);
				}
				}
			}
		}
	}

}
