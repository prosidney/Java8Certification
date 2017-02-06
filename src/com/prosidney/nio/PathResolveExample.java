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
        Path p2 = Paths.get("/pathtest/a.java");


        System.out.println("path resolve");
        Path toResolvePath = Paths.get("/pathtest/a.java");
        System.out.println(p1.resolve(toResolvePath));
        System.out.println();
        System.out.println();

        System.out.println("path relativize");
        System.out.println(p1.relativize(p2));
        System.out.println();
        System.out.println();

        System.out.println("path resolveSibling");
        Path siblingPath = Paths.get("siblings.java");
        System.out.println(p1.resolveSibling(siblingPath));
        System.out.println();
        System.out.println();


        Path toNormalize = Paths.get("//pathtest//..//a.java");
        System.out.println("path toNormalize");
        System.out.println(toNormalize.normalize());
    }
}
