package com.prosidney.java8.sumarizaraparadatoda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by admin on 01/02/17.
 */
public class WalkAndFindExample {
    public static void main(String[] args) throws IOException {
        String path = "/Users/Sidney/Dev/repositories/Java8Certification/pathtest";

        findExample(path);
        walkExample(path);
    }

    public static void findExample(String path) throws IOException {
        Stream<Path> pathStream =
                Files.find(Paths.get(path),
                           Integer.MAX_VALUE,
                           (p, a) -> p.endsWith("c.java") && a.isRegularFile());

        pathStream.forEach(System.out::println);
        System.out.println("WalkAndFindExample.findExample");
    }

    public static void walkExample(String path) throws IOException{

        Files.walk(Paths.get(path)).forEach(System.out::println);

        System.out.println("WalkAndFindExample.walkExample");
    }
}
