package de.adkon.sandbox.predicates;

import org.junit.Test;

import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class PredicateSandbox {
    Predicate<String> stringTooShort = (s) -> (s.length() < 8);
    Predicate<String> stringContainsC = (s) -> s.contains("c");

    @Test
    public void peterZuKurz() {
        assertThat(test("Peter", stringTooShort, "stringTooShort"), is(true));
    }

    @Test
    public void peterHatKeinC() {
        assertThat(test("Peter", stringContainsC, "hat c"), is(false));
    }

    @Test
    public void peterHatKeinCUndIstZuKurz() {
        assertTrue(test("Peter", stringTooShort.and(stringContainsC), "zu kurz UND hat kein c"));
    }

    @Test
    public void peterIstZuKurzUndHatKeinA() {
        assertTrue(test("Peter", stringTooShort.and(s -> !s.contains("a")), "ist zu kurz und hat kein a"));
    }

    @Test
    public void adamHatAUndIstZuKurz() {
        // FUNKTIONIERT NICHT (compile level)
        // assertTrue(test("adam", ((string) -> string.contains("a")).and(stringTooShort), "hat a und ist zu kurz"));
        //Lösung:
        Predicate<String> stringContainsA = s -> s.contains("a");
        assertTrue(test("adam", stringContainsA.and(stringTooShort), "hat a und ist zu kurz"));
    }


    public static <T> boolean test(T object, Predicate<T> predicate, String predicateDesciption) {
        boolean result = predicate.test(object);
        System.out.println("Testing: " + object.toString() + " " + predicateDesciption + " -> " + result);
        return result;
    }
}
