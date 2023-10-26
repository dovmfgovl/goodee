package collec.list;
//사용자 정의 제네릭 구현하기
public class GenericMaterial<T> {
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
}
/*
 *자료형 매개변수 T<type parameter> : 이 클래스가 사용되는 시점에서 실제 사용할 
 *자료형이 결정된다(컴파일 타임에 JVM 바꿔치기를 해준다).
 *단, static 변수형은 사용 불가함 - 약속 - 컨벤션
 *GenericMaterial은 제네릭의 자료형이다.
 *T라는 대체 문자를 사용하였다.
 *--초보개발자가 설계해서 사용할 일은 없음....이걸 다시 복습할 필요는 없다...--여기 뒤 부터가 중요
 */
 