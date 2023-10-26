package bclass.step1;

public class StudentTest {

	public static void main(String[] args) {
		Student st = new Student();
		System.out.println("학생 이름 : "+ st.getS_name());
		System.out.println("학번 : " + st.getS_no());
		System.out.println("학년 : " + st.getGrade());
		System.out.println("===================");
		st = new Student(2017242450, "나신입", 3);
//		st.setS_name("나신입");
//		st.setS_no(0054307);
//		st.setGrade(3);
		System.out.println("학생 이름 : "+ st.getS_name());
		System.out.println("학번 : " + st.getS_no());
		System.out.println("학년 : " + st.getGrade());		
		System.out.println("===================");
		st = new Student(2451770, "이하늘");
		System.out.println("학생 이름 : "+ st.getS_name());
		System.out.println("학번 : " + st.getS_no());
	}

}
