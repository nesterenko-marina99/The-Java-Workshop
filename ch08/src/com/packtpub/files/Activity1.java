package com.packtpub.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;

public class Activity1 {
    public static void main(String[] args) throws IOException {
        String pathString = System.getProperty("user.home");
        Path path = Paths.get(pathString);
        String fileName = "filesStructure.txt";
        Path filePath = Paths.get(pathString+ "/" +fileName);
        if (Files.exists(filePath)) {
            System.out.println("WARNING: file already exists in " + pathString);
        } else {
            try {
                Files.createFile(filePath);
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            Files.walkFileTree(path, Collections.emptySet(), 10, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
                    String toFile = "";
                    String[] pathArray = path.toString().split("/");
                    int depthInit = pathArray.length;

                    String[] fileArray = dir.toString().split("/");
                    int depthCurrent = fileArray.length;
                    for (int i = depthInit; i < depthCurrent; i++) {
                        toFile += "    ";
                    }
                    toFile += fileArray[fileArray.length - 1];
                    if (Files.exists(filePath)) {
                        try {
                            Files.write(filePath, Arrays.asList(toFile), StandardOpenOption.APPEND);
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException ioe) throws IOException {
                    System.out.println("visit file failed " + file);
                    return FileVisitResult.CONTINUE;
                }
            });

        }
    }

}
