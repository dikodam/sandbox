package de.adkon.lambdainterfaces;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConverterUser {

// TODO static calls to Converter.as() to create a hexConverter and a octalConverter

    static Converter hexConverterOldSkool = new Converter() {

        @NotNull
        @Contract(pure = true)
        public String supplier() {
            return "Hello World";
        }
        @NotNull
        @Contract("null -> !null")
        public String function(@Nullable String number) {
            return number + " LOL ";
        }
        public void consumer(String number) {
            System.out.println(number);
        }
        public String biFunction(String number1, String number2) {
            return number1 + " " + number2;
        }
    };

    public static void helloWorldPrinter  (String text) {
        System.out.println(text + " bloo ");
    }


    static Converter hexConverterNew = Converter.as(
            () -> "Hello World",
            (eingabe) -> eingabe + " LOL ",
            ConverterUser::helloWorldPrinter,
            (eingabe1, eingabe2) -> eingabe1 + " " + eingabe2
    );

    Converter c = new Converter() {
        @Override
        public String supplier() {
            return null;
        }

        @Override
        public String function(String number) {
            return null;
        }

        @Override
        public void consumer(String number) {

        }

        @Override
        public String biFunction(String number1, String number2) {
            return null;
        }
    };

    public static void main(String[] args) {
        System.out.println(hexConverterNew.biFunction("1", "2"));

    }

}
