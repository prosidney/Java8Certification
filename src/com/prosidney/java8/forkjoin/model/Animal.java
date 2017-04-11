package com.prosidney.java8.forkjoin.model;

/**
 * Created by Sidney on 2017-01-23.
 */
public class Animal {
    private String name;
    private Integer qtdPills;
    private boolean isMedicated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQtdPills() {
        return qtdPills;
    }

    public void setQtdPills(Integer qtdPills) {
        this.qtdPills = qtdPills;
    }

    public boolean isMedicated() {
        return isMedicated;
    }

    public void setMedicated(boolean medicated) {
        isMedicated = medicated;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", qtdPills=" + qtdPills +
                ", isMedicated=" + isMedicated +
                '}';
    }
}
