package collec.list;

public class GenericMaterialTest {

	public static void main(String[] args) {
		Powder p = new Powder();
		Plastic pt = new Plastic();
		GenericMaterial<Powder> tp3 = new GenericMaterial<>();
		//아래 코드에서 파라미터 이슈가 발생되지 않는건 Object이기 때문이다.
		tp3.setMaterial(p);
		//타입을 잘못 맞추면 ClassCastingException이 발동할 수 있다. - 멈춘다.
		//-> 제네릭<>을 사용하면 타입을 맞춰주지 않아도 된다.
		Powder p1 = tp3.getMaterial();
		System.out.println(p1.toString());
	}

}
