package de.dikodam.sandbox.java8streams.enums;

import java.util.stream.Stream;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.go();
    }

    private void go() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .map(this::intToEnum)
                .forEach(System.out::println);
    }

    private Bloo intToEnum(Integer integer) {
        return integer % 2 == 0 ? Bloo.A : Bloo.B;
    }
}
