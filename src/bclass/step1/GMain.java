package bclass.step1;
class G{
	int i = 1;
	static int j = 10;
	G(){ //생성자 추가해서 {} 실행시키면 아래 값들 1씩 증가됨(생성자 치환)
		j++;
		i = j;
	}
}
public class GMain {
//여러 개의 인스턴스가 하나의 전역변수를 공유하고 싶다면 static으로 한다.
	public static void main(String[] args) {
		G g = new G();
		System.out.println(g);//세 인스턴스 주소번지 다름
		System.out.println(g.i);//세 인스턴스 값이 같음 //셋 다 2 ///11
		System.out.println(G.j+1); //여러 번 인스턴스화 한 게 의미없다. 셋 다 11 ///12
		g = new G(); //G g = new G(); 에러 발생 - 같은 변수를 중복해서 적용할 수 없다.
		System.out.println(g);
		System.out.println(g.i); ///12
		System.out.println(G.j+1); ///13
		g = new G();
		System.out.println(g);
		System.out.println(g.i); ///13
		System.out.println(G.j+1); ///14
	}

}
