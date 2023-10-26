package achat.step1;

import java.util.ArrayList;
import java.util.List;

import com.step5.List4;

class Kiwi{
	String name = null; //골드키위, 그린키위
}
class Tomato{
	
}
public class List3 {
	List<String> bread = new ArrayList<>();
	List<Kiwi> kiwis = new ArrayList<>();
	List<Tomato> tomatos = new ArrayList<>();
	void methodA() {
		bread.add("소보로");
		Kiwi kiwi = new Kiwi();
		kiwi.name = "골드키위";
		//bread.add(kiwi); //에러 : 타입이 다르기 때문 - bread type은 String이니까. 타입을 맞춰야 함!! 아래처럼
		kiwis.add(kiwi);
		Kiwi kiwi2 = new Kiwi();
		kiwi2.name = "그린키위";
		kiwis.add(kiwi2);
		Tomato tomato = new Tomato();
		tomatos.add(tomato);
	}
	void methodB() {
		Kiwi kiwi = null;
		int i = 1;
		while(true) {
			kiwi = new Kiwi();
			System.out.println(kiwi); //주소번지가 바뀐다
			i++;
			if(i==5) {
				break;
			}
		}
	}
	//메인메소드는 개발자에게 제어권이 없다.
	public static void main(String[] args) {
		List3 list3 = new List3();
//		list3.methodA();
//		System.out.println(list3.bread.size());//1
//		System.out.println(list3.kiwis.size());//1 -> 2 (골드키위, 그린키위)
//		System.out.println(list3.tomatos.size());//1
		list3.methodB();
	}

}//end of List3
