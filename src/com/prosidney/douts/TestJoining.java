package com.prosidney.douts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 10/02/17.
 */
public class TestJoining {
    public static void main(String[] args) {
        List<Course> cList = Arrays.asList(
                new Course("803", "OCAJP 7"),
                new Course("808", "OCAJP 8"),
                new Course("809", "OCPJP 8")
        );

        cList.stream().filter(c->{
            System.out.println(c.getName().indexOf("8"));
            return c.getName().indexOf("8")>-1;
        })
                .map(c->c.getId())
                .collect(Collectors.joining("1Z0-"));

        cList.stream().forEach(c->System.out.println(c.getId()));
    }

    public static class Course{
        private String id;
        private String name;

        public Course(String id, String name){
            this.id = id; this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //accessors not shows
    }
}
