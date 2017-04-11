package com.prosidney.java8.douts;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by admin on 27/01/17.
 */
public class PathTest {
    static Path p1 = Paths.get("/Users/admin/git_repositories/prosidney/Java8Certification/nonjava");

    public static String getValue(){
        String x = p1.getName(0).toString();
        String y = p1.subpath(0, 1).toString();

        return x+" : "+y;
    }

    public static void main(String[] args) {
        System.out.println(getValue());
    }

}
