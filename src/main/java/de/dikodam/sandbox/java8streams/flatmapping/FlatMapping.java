package de.dikodam.sandbox.java8streams.flatmapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapping {

    public static void main(String[] args) {
        List<List<List<Integer>>> superlist = Arrays.asList(generate2DList(), generate2DList(), generate2DList());
        System.out.println(superlist.stream()
            .flatMap(List::stream)
            .flatMap(List::stream)
            .count());
    }

    private static List<List<Integer>> generate2DList() {
        return Arrays.asList(generateList(), generateList(), generateList());
    }

    public static List<Integer> generateList() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
    }
}
