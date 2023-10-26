package achat.step1;

import java.util.StringTokenizer;

public class ProtocalTest {

	public static void main(String[] args) {
		String msg = "200 | kiwi | tomato | 오늘 스터디 할까?";
		StringTokenizer st = new StringTokenizer(msg, "|"); //token
//		String protocol = st.nextToken(); //200
//		String from = st.nextToken(); //kiwi
//		String to = st.nextToken(); //tomato
//		String msg1 = st.nextToken(); //오늘 스터디할까?
		//System.out.println(protocol +", "+ from+", "+ to+", "+msg1);
		//while(boolean 타입만 올 수 있다) {
		while(st.hasMoreElements()) {
//			st.nextToken(); //200을 넘기게 됨
//			st.nextToken(); //kiwi를 넘기게 됨 (오라클 커서처럼 이동하기 때문에)
//			String s = st.nextToken(); //nextToken: 한 번 지나가게 되면 이전 값의 상태를 기억하지 못한다. - 이런 컨셉의 클래스(StringTokenizer)도 있음
			String s = (String)st.nextElement(); //리턴값이 Object기 때문에 String으로 치환(casting 연산자 사용)
			System.out.println(s);
		}
	}

}
