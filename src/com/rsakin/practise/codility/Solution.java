package com.rsakin.practise.codility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {

    public boolean doesStringContainVisibleCharacters(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        return !input.strip().isBlank();
    }

    public List<String> splitToLines(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        return input.lines().collect(Collectors.toList());
    }

    public String trimUnicodeString(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        // Note: The final implementation should operate on wider spectrum of whitespace characters than trim method
        return input.strip();
    }

    public String trimLeft(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        return input.stripLeading();
    }

    public String trimRight(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        return input.stripTrailing();
    }

    public String repeatStringFiveTimes(String input) {
        // Java 11 introduced a special String's method that could replace the expression below
        return input.repeat(5);
    }

    public void saveStringInFile(String fileContents, String filename) throws Exception {
        Path file = Paths.get(filename);
        Files.writeString(file, fileContents);
        // Please implement the rest of this method using one of the methods of the Files class
        // The function should write the given string to the file with the given name
    }

    public String readFileContents(String filename) throws Exception {
        Path file = Paths.get(filename);
        String fileContents = Files.readString(file);
        // Please implement the rest of this method using one of the methods of the Files class
        // The function should read the contents of the file and return it as a single String value
        return fileContents;
    }

    public List<String> filterOutEmptyStrings(List<String> input) {
        // Java 11 introduces new type of Predicate - please use it here
        return input.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }

}
