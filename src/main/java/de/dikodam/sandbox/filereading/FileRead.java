package de.dikodam.sandbox.filereading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FileRead {

    public static void main(String[] args) {
        String filetext = null;
        try (BufferedReader br = new BufferedReader(new FileReader("filename.txt"))){
            filetext = br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
