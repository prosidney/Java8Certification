package com.prosidney.parse;

/**
 * Created by Sidney on 2017-03-17.
 */
public class ChildModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "ChildModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
