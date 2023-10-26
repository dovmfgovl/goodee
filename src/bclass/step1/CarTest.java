package bclass.step1;

public class CarTest {

	public static void main(String[] args) {
		Car yourCar = CarFactory.getInstance();
		Car himCar = CarFactory.getInstance();
		Car herCar = CarFactory.getInstance();
		//insert here
		System.out.println(yourCar.getCarNum());
		System.out.println(himCar.getCarNum());
		System.out.println(herCar.getCarNum());
	}

}
