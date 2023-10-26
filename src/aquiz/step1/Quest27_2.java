package aquiz.step1;
//흐름을 바꾸는 코드 - 관심!
//MVC 패턴을 적용한 게시판에서 업무의 특성상 트랜잭션 처리가 필요할 때
//Model 계층에서 조건에 따라 하나의 업무로 규정되어 둘 다 처리되었을 때만 커밋하고
//어느 하나라도 문제가 발생되면 모두 롤백해야 하는 경우에 그 시점을 인터셉트 할 목적(관여하기 위해서 - 흐름을 바꾼다)으로 하여  사용될 수도 있다.
import java.util.Scanner;

//throw 예외를 강제로 일으킬때 사용한다.
public class Quest27_2 {
	static void m(int month) {//15
		try {
			if(month < 0 || month >11) { //이거나, 또는, 합집합, 둘 중에 하나여도 실행된다.
				throw new Exception();				
			}else {
				System.out.println("정상적인 처리를 한다.");
			}
		} catch (Exception e) {
			System.out.println("강제로 Exception 발생시킴- 유효범위가 아니라서");
		}
	}
	public static void main(String[] args) {
		System.out.println("원하는 달을 입력하시오.(예시: 0~11사이에 값)");
		Scanner sc = new Scanner(System.in);
		int month =sc.nextInt();//15
		Quest27_2.m(month);			
	}//////////  end of main
}
