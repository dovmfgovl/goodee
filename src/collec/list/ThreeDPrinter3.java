package collec.list;
//포괄적인 대신 직관적이지 않다.
//그래서 타입을 맞춰야 한다.
//그래서 ClassCastingException이 발동될 수 있다. - 런타임 오류(잡는 개발자)
//그래서 서버가 다운되기도 한다??
//그래서 포괄적인 타입은 위험하다.
public class ThreeDPrinter3 {
	private Object material;

	public Object getMaterial() {
		return material;
	}

	public void setMaterial(Object material) {
		this.material = material;
	}
}
