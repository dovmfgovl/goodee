package bclass.step1;
//샘플데이터 = 0054307 | 나신입 | 3
public class Student {
	private int s_no; //학번이다. - 0
	private String s_name; //학생이름 - null
	private int grade; //학년 - 0
	
	public Student(){	}
	public Student(int s_no){	}
	public Student(int s_no, String s_name){
		this.s_no = s_no;
		this.s_name = s_name;
	}
	public Student(int s_no, String s_name, int grade){
		this.s_no = s_no;
		this.s_name = s_name;
		this.grade = grade;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
