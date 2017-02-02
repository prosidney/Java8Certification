package com.prosidney.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/**
 * Created by admin on 01/02/17.
 */
public class WalkFileTreeExample {
    public static void main(String[] args) throws IOException {
        MyFileVisitor mfv = new MyFileVisitor();
        Files.walkFileTree(Paths.get("/Users/admin/git_repositories/prosidney/Java8Certification/pathtest"),
                           EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                           5,
                           mfv);
    }

    public static class MyFileVisitor implements FileVisitor<Path> {
        public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
            System.out.println("Visited "+p);
            return FileVisitResult.CONTINUE;
        }

        private final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/p*");
        private final PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:**/l*");

        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("preVisitDirectory " + dir.getFileName().toString());
            if(matcher.matches(dir) || matcher2.matches(dir)){
                return FileVisitResult.CONTINUE;
            }
            else{
                return FileVisitResult.SKIP_SUBTREE;
            }
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}
