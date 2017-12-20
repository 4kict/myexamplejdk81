package com.my.test.controllers;

/**
 * Created by SBT-Kiladze-GS on 15.12.2017.
 */
public class MyTest {

    //static final int SUM = IntStream.range(0, 40).parallel().reduce((n, m) -> n + m).getAsInt();

    public static void main(String[] args) {
//        MyTest asd = new MyTest();
//        System.out.println(asd.SUM);
//        Base asd = new Base();

        Thread t1 = new Thread(A::new);
        t1.setName("MyTread1");
        t1.start();
        new B();
        System.out.println("123qwe");
    }

    public void doSome() {

    }

    static class A {
        static B b = new B();
    }

    static class B {
        static A a = new A();
    }


}

class Base {
    static Base child = new Child();
}

class Child extends Base {
    static Integer i = 123;
}

