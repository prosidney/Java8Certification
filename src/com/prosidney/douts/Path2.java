package com.prosidney.douts;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by admin on 25/01/17.
 */
public class Path2 {
    public static void main(String[] args) throws IOException {
        Path3 mfc = new Path3();

        Files.walkFileTree(Paths.get("pathtest"), mfc);
        System.out.println(mfc.getCount());
    }

    public static class Path3 extends SimpleFileVisitor<Path>{
        private final PathMatcher matcher;
        private static int count;

        public Path3(){
            matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
        }

        void check(Path p){
            if(p != null && matcher.matches(p.getFileName())){
                count++;
            }

        }
        public int getCount(){
            return count;
        }

        public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
            check(p);
            return FileVisitResult.CONTINUE;
        }
    }
}
