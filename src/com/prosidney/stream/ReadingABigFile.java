package com.prosidney.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by admin on 17/01/17.
 */
public class ReadingABigFile {
    public static void main(String args[]) {
        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("/Users/admin/git_repositories/prosidney/Java8Certification/src/com/prosidney/stream/example.txt"),
                             Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split("")))
                    //.distinct()
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
