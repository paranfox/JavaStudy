package edu.java.interface05;

// 상속 : IS-A 관계가 성립할 때
// - 스마트 TV는 TV이다. (SmartTv is a TV)
// - class Smart Tv extends BasicTV {...}

// 구현(인터페이스) : HAS-A 관계가 성립할 때
// - TV는 리모콘을 가지고 있다. (TV has a remote controller)
// - class BasicTV implements RemoteController
public class InterfaceMain05 {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.turnOn();
		tv.turnOff();

		Audio audio = new Audio();
		audio.turnOn();
		audio.turnOff();

		System.out.println();
		RemoteController rc1 = new TV();
		rc1.turnOn();

		RemoteController rc2 = new Audio();
		rc2.turnOn();
	}

}
