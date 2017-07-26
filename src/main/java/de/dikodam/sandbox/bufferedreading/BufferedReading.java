package de.dikodam.sandbox.bufferedreading;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;

public class BufferedReading {

    public static void main(String[] args) {
        doBrReading();
    }

    private static void setCurrentDate(YearMonth current, LocalDate now) {
        current = YearMonth.from(now);
    }

    private static void doBrReading() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("sample.txt");
        if (resource == null) {
            System.err.println("file not found");
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(new File(resource.getFile())))) {
                System.out.println("Erste Zeile:" + br.readLine());
                System.out.println("zweite Zeile:" + br.readLine());
                br.lines().forEach(System.out::println);
            } catch (FileNotFoundException e) {
                System.err.println("file not found:");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("IO Ex");
            }
        }
    }
}
