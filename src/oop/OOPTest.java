package oop;

public class OOPTest {

    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.showName();
        System.out.println("-----------");
        Circle circle = new Circle();
        circle.showName();

        E e = new E();
        e.show();
    }

}

class Shape {
    public Shape() {
        System.out.println("shape");
    }

    public static void showName() {
        System.out.println("shape");
    }
}

class Circle extends Shape {
    public Circle() {
        super();
        System.out.println("circle");
    }

    public static void showName() {
        System.out.println("Circle");
    }
}

interface A {
    public static final int a = 100;

    public abstract void show();
}

interface B {
    void jump();
}

interface C {
    void sing();
}

interface D extends A, B, C {
    void sleep();
}

class E implements D {

    @Override
    public void show() {
        System.out.println(a);
    }

    @Override
    public void jump() {

    }

    @Override
    public void sing() {

    }

    @Override
    public void sleep() {

    }
}

abstract class Ani {
    int a = 100;
}