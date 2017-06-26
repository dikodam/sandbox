package de.dikodam.sandbox.lambdalibrary;

import java.util.stream.Stream;

import static de.dikodam.sandbox.lambdalibrary.Alarms.*;

public class Main {
    public static void main(String[] args) {
        Stream.of(ALARM_CLOCK, ANOTHER_ALARM, TV_ALARM, SMARTPHONE_ALARM)
            .map(Alarm::ring)
            .forEach(System.out::println);
    }
}
