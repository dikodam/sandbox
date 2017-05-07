package de.dikodam.sandbox.constructors;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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


    static List<Class<?>> classArrayList = Arrays.asList();

    static Predicate<Class<?>> noInterface = clazz -> !clazz.isInterface();
    static Predicate<Class<?>> notAbstract = clazz -> !Modifier.isAbstract(clazz.getModifiers());
    static Predicate<Class<?>> hasDefaultConstructor = clazz -> Stream.of(clazz.getConstructors())
            .anyMatch(constructor -> constructor.getParameterCount() == 0);

    private static void testStuff() {
        Class[] classArray = classArrayList.stream()
                .filter(noInterface
                        .and(clazz -> !Modifier.isAbstract(clazz.getModifiers()))
                        .and(clazz -> Stream.of(clazz.getConstructors())
                                .anyMatch(constructor -> constructor.getParameterCount() == 0)))
                .toArray(Class[]::new);
    }

}
