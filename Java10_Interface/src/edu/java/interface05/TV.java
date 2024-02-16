package edu.java.interface05;

public class TV implements RemoteController {

	@Override
	public void turnOn() {
		System.out.println("TV 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("TV 꺼짐");
	}

}
