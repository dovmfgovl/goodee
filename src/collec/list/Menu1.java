package collec.list;

import java.util.Scanner;

public class Menu1 {

	public static void main(String[] args) {
		//Scanner~(in); 이 for문 안에 있는 것도 밖에 있는 것의 차이는 무엇?
		//임의의 숫자를 채번하는 함수라면 씨앗이 되는 값이 필요하다
		//채번하는데 있어서 빈도 수에 관련이 있으니 변하면 안된다.
		//임의의 값을 채번할 때 씨앗이 되는 값이 계속 변경되어야 하는 룰이면
		//for문 안에 있어야 한다.
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			String menu = "-1"; //-1 : End of file
			System.out.println("전체조회이면 1번을 입력하고 상세조회이면 2번을 입력하시오.");
			menu = sc.nextLine();
			if("1".equals(menu)) {
				//return;// 메인메소드를 빠져나간다.
				continue;
			}else if("2".equals(menu)) {
				//return; //for문 빠져나가는 건 break;
				continue;
			}
			System.out.println("여기");
		}
		//여기서 변수 j에 접근이 가능하다 | 아니다.
		//Menu1 m1 = new Menu1();
		//System.out.println(j); //안 됨, 인스턴스화 해도 안 됨(지역변수니까)
	}

}
