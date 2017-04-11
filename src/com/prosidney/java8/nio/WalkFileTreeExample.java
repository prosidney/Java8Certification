package com.prosidney.java8.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/**
 * Created by admin on 01/02/17.
 */
public class WalkFileTreeExample {
    public static class MyFileVisitor implements FileVisitor<Path> {
        private final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.{java}");
        private final PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.{java}");

        public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
            boolean duploAsteristico = matcher.matches(p.getFileName());
            boolean unicoAsteristico = matcher2.matches(p.getFileName());

            System.out.println("duploAsteristico " + duploAsteristico);
            System.out.println("unicoAsteristico " + unicoAsteristico);

            return FileVisitResult.CONTINUE;
        }


        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("===============preVisitDirectory====================");
            System.out.println(dir.toString());

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("===============postVisitDirectory====================");

            return FileVisitResult.CONTINUE;
        }
    }




    public static void main(String[] args) throws IOException {
        MyFileVisitor mfv = new MyFileVisitor();
        Files.walkFileTree(Paths.get("/Users/Sidney/Dev/repositories/Java8Certification/pathtest"),
                EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                5,
                mfv);
    }
}
