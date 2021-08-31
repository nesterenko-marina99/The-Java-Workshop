package com.packtpub.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise01 {
    public static void main(String[] args) throws IOException {
        String pathString = System.getProperty("user.home");
        Path path = Paths.get(pathString);
        Stream<Path> fileNames = Files.list(path).filter(Files::isDirectory);
        fileNames.limit(5).forEach((item) -> {
            System.out.println(item.toString());
            try {
                Stream<Path> fileNames2 = Files.list(item).filter(Files::isDirectory);
                fileNames2.forEach(System.out::println);
            } catch (IOException ioe) {}
        });
    }
}
