package de.dikodam.sandbox.lambdainterfaces;

import java.util.function.Supplier;


import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Converter {

    String supplier();

    String function(String number);

    void consumer(String number);

    String biFunction(String number1, String number2);

    static Converter as(Supplier<String> s, Function<String, String> f, Consumer<String> c, BiFunction<String, String,
            String> bf) {
        return new Converter() {
            @Override
            public String supplier() {
                return s.get();
            }

            @Override
            public String function(String number) {
                return f.apply(number);
            }

            @Override
            public void consumer(String number) {
                c.accept(number);
            }

            @Override
            public String biFunction(String number1, String number2) {
                return bf.apply(number1, number2);
            }
        };
    }
}
