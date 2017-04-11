package com.prosidney.java8.parse;

import java.util.List;

/**
 * Created by Sidney on 2017-03-17.
 */
public class Model {
    private List<ChildModel> list;

    public List<ChildModel> getList() {
        return list;
    }

    public void setList(List<ChildModel> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Model{" +
                "list=" + list +
                '}';
    }
}
