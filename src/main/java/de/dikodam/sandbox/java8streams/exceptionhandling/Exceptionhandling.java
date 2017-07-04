package de.dikodam.sandbox.java8streams.exceptionhandling;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exceptionhandling {

    private static NestedExceptionProvider exceptionProvider;

    public static void main(String[] args) {
        doSomeMagic();
    }

    private static void doSomeMagic() {
        try {
            setUpList();
            exceptionProvider.doIt();
        } catch (Exception e) {
            // in case of IOException throw RuntimeException
            Stream.iterate(e, Throwable::getCause)
                .filter(isIOException)
                .findFirst()
                .ifPresent((ex) -> {
                    throw new RuntimeException(e);
                });
        }
    }

    private static Predicate<? super Throwable> isIOException = (e) -> e instanceof IOException;

    private static void setUpList() {
        exceptionProvider = new NestedExceptionProvider();
        NestedExceptionProvider iterator = exceptionProvider;
        for (int i = 0; i < 10; i++) {
            iterator.setNext(new NestedExceptionProvider());
            iterator = iterator.getNext();
        }

    }

}
