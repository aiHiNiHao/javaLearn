package simpletest;

import java.util.ArrayList;

public class SimpleTest {

	public static void main(String[] args) {
		method_testListValue();
	}
	
	
	public static void method_testListValue() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("lijing", 25));
		list.add(new Person("xiaowang", 50));
		
		Person person = list.get(0);
		person = null;
		System.out.println("name = "+list.get(0).name);//结果 name = lijing
		
		changeObjectValue(list.get(0));
		System.out.println("name = "+list.get(0).name);//结果 name = taozi
		
	
	}
	
	public static void changeObjectValue(Person person) {
		person.name = "taozi";
	}
	
	static class Person{
		public String name;
		public int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
