package de.adkon.constructors;

import java.lang.reflect.Modifier;
import java.util.stream.Stream;


public class ConstructorHack {


    public static void main(String[] args) {
        if (defaultConstructorExists(ConstructorHack.class)) {
            System.out.println("JO");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean defaultConstructorExists(Class<?> classObject) {
        return Stream.of(classObject.getConstructors())
                .anyMatch(constructor -> constructor.getParameterCount() == 0);
    }

    private static boolean isClassAbstract(Class<?> classObject) {
        return Modifier.isAbstract(classObject.getModifiers());
    }
}
