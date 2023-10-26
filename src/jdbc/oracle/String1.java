package jdbc.oracle;

public class String1 {

	public static void main(String[] args) {
		String s1 = "나초보";
		String s2 = "나초보";
		s2 = s1;
		System.out.println(s1==s2);// 주소번지가 같니? true
		System.out.println(s1.equals(s2));//주소번지가 참조하는 값을 비교하는 것.
		String s3 = new String("나초보");
		String s4 = new String("나초보");
		System.out.println(s3==s4);// 주소번지가 같니? false
		System.out.println(s3.equals(s4));//주소번지가 참조하는 값을 비교하는 것.		true
		s4 = s2; //s4를 s2로 치환
		System.out.println(s2==s4);// 주소번지가 같니? true
		System.out.println(s2.equals(s4));//주소번지가 참조하는 값을 비교하는 것.		true
	}

}