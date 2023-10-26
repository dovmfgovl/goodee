package collec.list;
//제네릭을 사용한다는 건 주소번지를 두 번 접근해야 값에 도달함
//데이터셋 역할을 하는 클래스 설계에 대한 이해가 필요하다.
//Spring Boot - DB연동을 직접하지 않는다.(DML을 사용하지 않는다) - 그런데 DB연동은 된다.
//-> 자동(추상적이다 - 쿼리문이 안 보임)으로 해준다. - Hibernate - 데이터베이스의 테이블 관계를 클래스 설계로 처리하기 때문에
//쿼리문 없이도 DB연동이 가능하다.
//List<Object> -> List<Element> -> List<T> T는 type parameter -> T로 바꾼 이유: 개발자의 자유도를 높인다.
public class ThreeDPrinter2 {
	//private Powder material; //타입이 다르다
	//코드 수정양이 많아지면 1) 오타 발생이 많다. 2) 사이드이펙트 발생할 가능성 높다 - 부작용
	//private Object material; //타입이 너무 포괄적이다. - 직관적이지 않다. - 유지보수에 어렵다
	private Plastic material;

	public Plastic getMaterial() {
		return material;
	}

	public void setMaterial(Plastic material) {
		this.material = material;
	}
}
