package com.step5;

public abstract class Quak implements QuakBehavior {

	@Override
	public void quack() {
		System.out.println("꽥~꽥");
	}
}
