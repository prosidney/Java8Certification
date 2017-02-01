package com.prosidney.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by admin on 01/02/17.
 */
public class PathResolveExample {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("/pathtest/dir1/dir12/d.java");
        Path p2 = Paths.get("/pathtest/dir2/b.java");


        System.out.println(p1.resolve(p2));

        System.out.println(p1.relativize(p2));

        System.out.println(p1.resolveSibling(p2));
    }
}
