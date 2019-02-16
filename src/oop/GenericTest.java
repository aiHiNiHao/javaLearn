package oop;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args){
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        numbers.addAll(integers);
    }
}

class Person<T, E>{
    public T t;
    public E e;
    public Person(T t, E e){
        this.t  = t;
        this.e = e;
    }
}

class Student extends Person<String, Integer>{

    public Student(String name, Integer age) {
        super(name, age);
    }
}
