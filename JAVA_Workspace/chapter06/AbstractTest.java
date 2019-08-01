package chapter06;

/**
 * 
 * Abstract
 *  메서드
 *   - 메서드를 선언부만 작성하고 구현부는 공백.
 *   - sub클래스에서 추상메서드를 강제로 구현하도록 함.
 *   - 추상메서드를 sub클래스에서 구현하지 않으면 에러 발생.
 *   [access modifier] abstract 리턴타입 메서드명(인자){};
 *   
 *  클래스
 *   - 객체 생성 불가
 *   - 상속 전용, 다형성 전용
 *   - 클래스 내에 추상메서드가 있으면 반드시 추상 클래스로 선언해야 함.
 *   - 주의 점 : 생성자는 필요하다면 선언해 주어야 한다, 추상클래스라고 생성자가 없는것이 아님.
 *    -> sub 클래스의 생성자에서 무조건 super()가 불리기 때문에
 */

abstract class Animal { // 추상메서드를 작성하기 위해서는 추상클래스로 선언해야 한다.
	private String name;
	private String kind;
	private int age;

	public abstract void bark();
	public abstract void special();
	public Animal() {
	}

	public Animal(String name, String kind, int age) {
		super();
		this.name = name;
		this.kind = kind;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class Dog extends Animal { // 추상메서드롤 작성된 메서드는 반드시 자식에서 구현하여 오버라이딩 해야 한다.
	@Override
	public void bark() {
		System.out.println("월월~");
	}

	public void keep() {
		System.out.println("지킨다!");
	}

	@Override
	public void special() {
		keep();
	}
}

class Cat extends Animal { // 추상메서드롤 작성된 메서드는 반드시 자식에서 구현하여 오버라이딩 해야 한다.
	@Override
	public void bark() {
		System.out.println("애용~");
	}

	public void jump() {
		System.out.println("Jump!");
	}

	@Override
	public void special() {
		jump();
	}
}

public class AbstractTest {
	public static void main(String[] args) {
		// Animal ani = new Animal(); // 추상클래스는 객체를 생성할 수 없다.

		Animal ani = new Dog(); // 추상클래스라도 다형성을 적용하여 sub 객체를 참조할 수 있다.

		Animal[] anis = new Animal[2]; // 추상클래스라도 배열 객체는 생성할 수 있다.
		anis[0] = new Dog();
		anis[1] = new Cat();
		for (Animal animal : anis) {
			animal.bark();
			
//			if (animal instanceof Dog) {
//				Dog dog = (Dog) animal;
//				dog.keep();
//			} else if (animal instanceof Cat) {
//				Cat cat = (Cat) animal;
//				cat.jump();
//			}
			animal.special();
		}

	}
}
