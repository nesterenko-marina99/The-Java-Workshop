package com.packtpub.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise01 {
    public static void main(String[] args) throws IOException {
        String pathString = System.getProperty("user.home");
        Path path = Paths.get(pathString);
        Files.walkFileTree(path, Collections.emptySet(), 2, new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attr) {
                System.out.println(dir.toString());
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFileFailed (Path file, IOException ioe){
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
