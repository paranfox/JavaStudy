package edu.java.inherit04;

public class InheritMain04 {

	public static void main(String[] args) {
		// 이걸 묶어서 처리한다면 상속이 필요하다.
		Animal animal = new Animal("동물");
		animal.speak();
		
		System.out.println();
		Dog dog = new Dog("토토", "시고르자브종");
		dog.speak();
		
		System.out.println();
		Cat cat = new Cat();
		cat.speak();
		
		// 상속을 사용하는 가장 강력한 기능 중 하나
		// 그저 "말해"라고 하면 전부다 말을 한다
		// 단. 나오는 내용은 다르게 나온다.
		Animal[] a = new Animal[3];
		a[0] = animal;
		a[1] = dog;
		a[2] = cat;
		for(int i =0; i < a.length; i++) {
			a[i].speak();
		}

	} // end main()

} // end InheritMain04
